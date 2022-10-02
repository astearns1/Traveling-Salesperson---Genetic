package csc320.assignment.pkg1;

import java.util.*;

public class CSC320Assignment1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //Creates initial population & finds path
        Population pop = new Population(9);
        pop.findPath();
    }    
}

//----------------------------------------------------------------------------\\
class Population{
    Scanner in = new Scanner(System.in);
    Random r = new Random();
    
    double maxDist, minDist, trueMin = 500; 
    int generation = 0, numberOfCities, genome = 16; //Counts generations
    boolean done = false; //Variable to control while loop
    
    Route minPath; //Holds the true min path
    
    Route[] routes = new Route[genome]; //Holds the chromosomes
    Route[] children = new Route[genome]; //Temporarily holds new generation
    
    double[] cumulative = new double[genome]; //Holds cumulative f(x) values to pick parents
    double[] reciprocal = new double[genome]; //Holds the reciprocal of distance to place higher value on lower distances
    double[] fitness = new double[genome]; //Holds the fitness scores of each route
    
    double[][] distances;
    City[] cities;
    
    //Contrustor to initialize first generation
    public Population(int n){
        cities = new City[n]; //Holds the cities
        distances = new double[n][n]; //Holds the values between the cities
        numberOfCities = n;
        minPath = new Route(numberOfCities);
        
        //Input cities into the program
        cities[0] = new City(1, 1);
        cities[1] = new City(4, 5);
        cities[2] = new City(7, 4);
        cities[3] = new City(5, 4);
        cities[4] = new City(6, 7);
        cities[5] = new City(8, 7);
        cities[6] = new City(4, 8);
        cities[7] = new City(2, 4);
        cities[8] = new City(9, 2);
        
        distArray(); //Create distance array
        
    }  
    
    //Method to do multiple generations
    public void findPath(){
        //Create initial routes
        for(int i = 0; i < routes.length; i++){
            routes[i] = new Route(numberOfCities);
            children[i] = new Route(numberOfCities);
            routes[i].fillParent();          
        }
        
        while(!done){
            generation++; //Keeps track of generations
//            System.out.println("GENERATION " + generation);
                        
            findDist(); //Finds the distance for each route
            distMaxMin(); //Finds the smallest and largest distances
            cumulative(); //Fitness scores for each route
            
                        
//            printRoutes();
//            System.out.println();
            
            if(maxDist == minDist){ //All routes are the same
                done = true;
                System.out.println("DONE BY SOLUTION, GENERATION " + generation);
                printRoutes();
            }
            else if(generation > 50 && totalMin() >= genome/2){ //At least half of the routes are the same
                done = true;
                System.out.println("DONE BY CLOSE, GENERATION " + generation);
                printRoutes();
            }
            else if(generation == 5000){ //Forces the program to end after 5000 generations
                done = true;
                System.out.println("DONE BY FORCE, GENERATION " + generation);
                printRoutes();
            }
            else{ //Creates another generation only after all previous are false
                breed(); //Creates the new generation
                
                //Transfer children to the population
                for (int i = 0; i < routes.length; i++) {
                    for (int j = 0; j < numberOfCities; j++) {
                        routes[i].path[j] = children[i].path[j];
                    }
                }
                resetChildren();//Makes the children blank routes again
            }            
        }
        System.out.println();
    }
    
    //Method to create new generation
    public void breed(){
        double parent1In, parent2In; 
        int start, end, separation, temp, insertionP;
        Route parent1 = new Route(numberOfCities);
        Route parent2 = new Route(numberOfCities);
        
        
        for(int index = 0; index < children.length; index += 2){
            //Find values to match the cumulative array for the parents
            parent1In = r.nextDouble();
            parent2In = r.nextDouble();            
            
            //Makes parent1 equal to selected route from population
            for(int i = 0; i < cumulative.length; i++){
                if(parent1In < cumulative[i]){
                    for(int j = 0; j < numberOfCities; j++){
                        parent1.path[j] = routes[i].path[j];
                    }
                    break;
                }
            }
            
            //Makes parent2 equal to selected route from population
            for (int i = 0; i < cumulative.length; i++) {
                if (parent2In < cumulative[i]) {
                    for (int j = 0; j < numberOfCities; j++) {
                        parent2.path[j] = routes[i].path[j];
                    }
                    break;
                }
            }
            
            //Find the portion of each parent to transfer to each child
            start = r.nextInt(numberOfCities);
            do{
                end = r.nextInt(numberOfCities);
            }while(end == start);
            
            if (start < end)
                separation = end - start;
            else
                separation = numberOfCities - start + end;
            
            //Copies kept portion from parents to children
            for(int i = 0; i < separation; i++){
                children[index].path[i] = parent1.path[(start + i) % numberOfCities];
                children[index+1].path[i] = parent2.path[(start + i) % numberOfCities];
            }
            
            //Fills in the remaining portion of 1st child
            insertionP = separation;
            for(int i = 0; i < numberOfCities; i++){
                int j;
                for(j = 0; j < numberOfCities; j++){
                    if(parent2.path[(start + i) % numberOfCities] == children[index].path[j])
                        break;
                }
                if(j == numberOfCities)
                    children[index].path[insertionP++] = parent2.path[(start + i) % numberOfCities];
            }
            
            //Fills in the remaining portion of 2nd child
            insertionP = separation;
            for (int i = 0; i < numberOfCities; i++) {
                int j;
                for (j = 0; j < numberOfCities; j++) {
                    if (parent1.path[(start + i) % numberOfCities] == children[index + 1].path[j]) {
                        break;
                    }
                }
                if (j == numberOfCities) {
                    children[index + 1].path[insertionP++] = parent1.path[(start + i) % numberOfCities];
                }
            }
            
            //Mutation portion, mutations around 1 out of every 1000 generations
            int mutateRate = r.nextInt(1000*genome);
            if (mutateRate == 0) {
                int a = r.nextInt(numberOfCities);
                int b;
                do {
                    b = r.nextInt(numberOfCities);
                } while (end == start);

                temp = children[index].path[a];
                children[index].path[a] = children[index].path[b];
                children[index].path[b] = temp;
                //System.out.println("Mutation, Generation " + generation +", Child " + index);
            }
        }        
    }
    
    //Method to calculate the distance of each path
    private void findDist(){
        for(int i = 0; i < routes.length; i++){
            double dist = 0;
            
            //Moves through the route to calculate distance
            for(int j = 0; j < distances.length-1; j++){
                dist += distances[routes[i].path[j]] [routes[i].path[j+1]];
            }
            
            //Adds the distance from the last city to the original city
            dist += distances[routes[i].path[numberOfCities-1]] [routes[i].path[0]];
            routes[i].distance = dist; //Assigns the distance to each route
        }
    }
    
    //Fills the cumulative f(x) array with values
    public void cumulative(){
        double total = 0;
        
        //Makes the lower distances a higher value
        for(int i = 0; i < reciprocal.length; i++){
            reciprocal[i] = (maxDist + .001) - routes[i].distance;
            total += reciprocal[i];
        }
        
        //Calculates the fitness score of each route
        for(int i = 0; i < fitness.length; i++){
            fitness[i] = reciprocal[i]/total;
        }
        
        //Fills the cumulative array with the fitness scores
        cumulative[0] = fitness[0];
        for(int i = 1; i < cumulative.length; i++){
            cumulative[i] = fitness[i] + cumulative[i-1];
        }
    }
    
    //Finds the max and min distances of the routes to determine if we can stop
    public void distMaxMin(){
        minDist = 500000000;
        maxDist = 0;
        
        for(int i = 0; i < routes.length; i++){
            //Checks to find the smallest distance in each generation
            if(routes[i].distance < minDist){
                minDist = routes[i].distance;                
            }
            
            //Checks to see if there is a all-time minimum distance
            if(routes[i].distance < trueMin){
                trueMin = routes[i].distance;
                for(int j = 0; j < numberOfCities; j++){
                    minPath.path[j] = routes[i].path[j];
                }
            }
            
            //Checks to find the longest distance in each generation
            if(routes[i].distance > maxDist) {
                maxDist = routes[i].distance;
            }
        }
    }

    //Method to find how many routes in each generation equal the all-time minimum
    public int totalMin(){
        int count = 0;
        for(int i = 0; i < routes.length; i++){
            if(routes[i].distance == trueMin){
                count++;
            }
        }
        
        return count;
    }
    
    //Makes blank routes for the children
    public void resetChildren(){
        for(int i = 0; i < children.length; i++){
            children[i].clearChild();
        }
    }
    
    //Fills the array full of distances between cities, [1][3] - distance from city 1 to city 3
    private void distArray() {
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[0].length; j++) {
                if (i == j) {
                    distances[i][j] = 0;
                } else {
                    double x1 = cities[i].getX();
                    double y1 = cities[i].getY();
                    double x2 = cities[j].getX();
                    double y2 = cities[j].getY();
                    double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                    distances[i][j] = length;
                    distances[j][i] = length;
                }
            }
        }
    }
    
    //Method to print out the routes when called with the distance for each route
    public void printRoutes(){
        for(int i = 0; i < routes.length; i++){
            System.out.printf("%9s","Path " + (i+1) + ": ");
            routes[i].printPath();
            System.out.print(", Distance: ");
            System.out.printf("%10f", routes[i].distance);
            System.out.println();
        }
//        System.out.println();
//        System.out.println("MINIMUM");
//        System.out.print("Path: ");
//        minPath.printPath();
//        System.out.println(" | " + trueMin);
//        System.out.println();
    }
}

//----------------------------------------------------------------------------\\
//Class that holds the individual routes and their distance values
class Route{
    Random r = new Random();
    int[] path;
    double distance;
    
    //Constructor used to actually create routes
    public Route(int n){
        path  = new int[n];
        for (int i = 0; i < path.length; i++) {
            path[i] = -1;
        }
    }    

    //Method to shuffle the order of the original generation
    private void shuffle() {
        for(int i = 1; i <= 100; i++){
            int a = r.nextInt(path.length);
            int b = r.nextInt(path.length);
            int temp = path[a];
            path[a] = path[b];
            path[b] = temp;
        }
    }
    
    //Creates initial population
    public void fillParent(){
        for (int i = 0; i < path.length; i++) {
            path[i] = i;
        }
        shuffle();
    }
    
    //Sets array to a blank route
    public void clearChild(){
        for(int i = 0; i < path.length; i++){
            path[i] = -1;
        }
    }
    
    //Method to print the path taken
    public void printPath(){
        for(int i = 0; i < path.length; i++){
            System.out.print((path[i]+1) + " ");
        }
    }    
}

//----------------------------------------------------------------------------\\
class City{ //Holds coordinates of city to determine distances
    double x;
    double y;
    
    public City(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }    
}