Problem: Find the shortest path for a salesman to travel between 9 cities given the coordinates of the cities
Encoding: To create the initial population, I made all the routes 1 through 9 and then shuffled by swapping two elements 100 times for each route\
Crossover: Used random integers functions to find the start and end portion of the parent to keep for each child. 
	The kept portion parent 1 went to child 1 and from parent 2 to child 2. Then I filled the remaining portion with elements of the other parent.
	I started at the beginning of the kept portion of the other parent and checked to see if the city was already in the route.
	If it was, I skipped and went to the next city until all 9 cities were checked.
Mutation: Used a random integer from 0 to 16000, and mutated if it equaled 0. I used 16000 because my population is 16 and I wanted mutation roughly every 1000 generations.
	I then switched two random cities in the path.
Program End: I ended the program if it reached 5000 generations, if all the distances were the same, 
	or if at least 8 equaled the all time minimum value found during the running of the program and it was after 50 generations, whichever came first

Best Path: 143965728 for a total distance of roughly 27.56 units


EXAMPLE----------------------------------------------------

Trial 1:
GENERATION 690
 Path 1: 1 4 5 7 2 8 3 9 6 , Distance:  37.781405
 Path 2: 5 7 1 4 3 9 6 2 8 , Distance:  36.487492
 Path 3: 6 5 7 3 9 2 8 1 4 , Distance:  32.536433
 Path 4: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
 Path 5: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
 Path 6: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
 Path 7: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
 Path 8: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
 Path 9: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
Path 10: 2 8 1 7 4 3 9 6 5 , Distance:  31.893098
Path 11: 8 1 4 3 9 6 5 7 2 , Distance:  27.561860
Path 12: 8 1 4 9 3 6 5 7 2 , Distance:  28.097254
Path 13: 5 7 2 8 1 4 3 9 6 , Distance:  27.561860
Path 14: 5 7 2 8 1 4 3 9 6 , Distance:  27.561860
Path 15: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
Path 16: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860

Trial 2:
GENERATION 1109
 Path 1: 3 4 1 8 2 7 5 6 9 , Distance:  27.561860
 Path 2: 8 2 7 5 6 9 3 4 1 , Distance:  27.561860
 Path 3: 6 9 3 4 1 8 2 7 5 , Distance:  27.561860
 Path 4: 6 9 3 4 8 1 2 7 5 , Distance:  28.325792
 Path 5: 9 3 4 1 8 2 7 5 6 , Distance:  27.561860
 Path 6: 1 8 2 9 3 4 7 5 6 , Distance:  33.636443
 Path 7: 2 7 5 6 9 3 4 1 8 , Distance:  27.561860
 Path 8: 6 9 3 4 1 8 2 7 5 , Distance:  27.561860
 Path 9: 8 2 7 5 6 9 3 4 1 , Distance:  27.561860
Path 10: 2 8 7 5 6 9 3 4 1 , Distance:  30.871719
Path 11: 9 3 4 1 8 2 7 5 6 , Distance:  27.561860
Path 12: 8 7 5 2 6 9 3 4 1 , Distance:  32.098491
Path 13: 5 6 9 3 4 1 8 2 7 , Distance:  27.561860
Path 14: 1 8 2 7 5 6 9 3 4 , Distance:  27.561860
Path 15: 8 2 7 5 6 9 3 4 1 , Distance:  27.561860
Path 16: 7 5 6 9 3 4 1 8 2 , Distance:  27.561860

Trial 3:
GENERATION 925
 Path 1: 9 6 5 7 2 3 8 1 4 , Distance:  33.131779
 Path 2: 3 9 6 5 7 2 8 4 1 , Distance:  32.107787
 Path 3: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
 Path 4: 7 2 8 1 3 9 6 5 4 , Distance:  32.319379
 Path 5: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
 Path 6: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 7: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
 Path 8: 2 8 7 1 4 3 9 6 5 , Distance:  34.079851
 Path 9: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
Path 10: 8 1 4 3 9 6 5 7 2 , Distance:  27.561860
Path 11: 9 6 5 7 2 8 1 4 3 , Distance:  27.561860
Path 12: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
Path 13: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
Path 14: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
Path 15: 9 6 5 7 2 8 1 4 3 , Distance:  27.561860
Path 16: 6 5 7 2 9 8 1 4 3 , Distance:  33.671685

Trial 4:
GENERATION 199
 Path 1: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 2: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 3: 6 5 7 8 1 4 3 9 2 , Distance:  32.001997
 Path 4: 8 1 4 6 5 7 2 9 3 , Distance:  33.300365
 Path 5: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
 Path 6: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
 Path 7: 8 4 3 9 6 5 7 2 1 , Distance:  28.325792
 Path 8: 4 8 1 3 9 6 5 7 2 , Distance:  29.448210
 Path 9: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
Path 10: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
Path 11: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
Path 12: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
Path 13: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
Path 14: 5 7 2 8 1 4 3 9 6 , Distance:  27.561860
Path 15: 9 6 7 2 8 1 4 3 5 , Distance:  33.613700
Path 16: 7 2 9 6 5 8 1 4 3 , Distance:  36.092249

Trial 5:
GENERATION 441
 Path 1: 6 5 7 2 8 4 3 9 1 , Distance:  34.582365
 Path 2: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 3: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 4: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
 Path 5: 1 4 2 8 3 9 6 5 7 , Distance:  33.429569
 Path 6: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
 Path 7: 7 2 4 8 1 3 9 5 6 , Distance:  32.067180
 Path 8: 5 7 2 8 1 4 3 9 6 , Distance:  27.561860
 Path 9: 5 7 2 3 9 6 1 8 4 , Distance:  34.869892
Path 10: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
Path 11: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
Path 12: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
Path 13: 4 6 5 3 9 7 2 8 1 , Distance:  33.441941
Path 14: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
Path 15: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
Path 16: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860

Trial 6:
GENERATION 1144
 Path 1: 6 5 7 2 8 3 9 1 4 , Distance:  34.605462
 Path 2: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
 Path 3: 9 3 6 1 4 5 7 2 8 , Distance:  38.124773
 Path 4: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
 Path 5: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
 Path 6: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 7: 6 5 7 2 8 1 4 3 9 , Distance:  27.561860
 Path 8: 6 5 7 2 8 1 4 3 9 , Distance:  27.561860
 Path 9: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
Path 10: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
Path 11: 4 7 8 1 3 9 6 5 2 , Distance:  32.635810
Path 12: 7 4 3 9 6 5 2 8 1 , Distance:  31.893098
Path 13: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
Path 14: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
Path 15: 1 7 2 8 4 3 9 6 5 , Distance:  35.589537
Path 16: 7 1 4 9 3 6 5 2 8 , Distance:  34.615245

Trial 7:
GENERATION 274
 Path 1: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
 Path 2: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
 Path 3: 4 3 8 1 9 6 5 7 2 , Distance:  31.973836
 Path 4: 8 1 4 3 9 6 5 7 2 , Distance:  27.561860
 Path 5: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
 Path 6: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
 Path 7: 9 6 5 7 2 8 1 4 3 , Distance:  27.561860
 Path 8: 7 2 8 1 9 6 5 4 3 , Distance:  33.721901
 Path 9: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
Path 10: 3 4 9 6 5 7 2 1 8 , Distance:  31.969501
Path 11: 5 7 2 6 8 1 4 3 9 , Distance:  35.238065
Path 12: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
Path 13: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
Path 14: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
Path 15: 6 5 7 2 8 1 4 3 9 , Distance:  27.561860
Path 16: 2 6 8 1 5 7 4 3 9 , Distance:  39.171420

Trial 8:
GENERATION 348
 Path 1: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 2: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 3: 1 4 3 9 6 5 7 8 2 , Distance:  30.871719
 Path 4: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
 Path 5: 5 7 2 8 1 4 3 9 6 , Distance:  27.561860
 Path 6: 3 9 6 5 7 8 2 1 4 , Distance:  30.871719
 Path 7: 5 7 2 8 1 4 3 9 6 , Distance:  27.561860
 Path 8: 2 1 4 3 9 5 7 8 6 , Distance:  38.547923
 Path 9: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
Path 10: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
Path 11: 5 7 2 8 1 3 9 6 4 , Distance:  32.674983
Path 12: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
Path 13: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
Path 14: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
Path 15: 6 5 7 3 9 2 8 1 4 , Distance:  32.536433
Path 16: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860

Trial 9:
GENERATION 1771
 Path 1: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
 Path 2: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
 Path 3: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 4: 4 3 9 6 5 7 2 8 1 , Distance:  27.561860
 Path 5: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
 Path 6: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
 Path 7: 8 1 4 3 9 6 5 7 2 , Distance:  27.561860
 Path 8: 8 1 4 3 9 6 5 7 2 , Distance:  27.561860
 Path 9: 9 6 5 7 2 1 4 3 8 , Distance:  36.615197
Path 10: 4 3 9 6 5 7 2 1 8 , Distance:  28.325792
Path 11: 1 2 3 4 9 6 5 7 8 , Distance:  31.603915
Path 12: 1 2 3 4 9 6 5 7 8 , Distance:  31.603915
Path 13: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
Path 14: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
Path 15: 4 9 6 5 7 3 2 8 1 , Distance:  32.367847
Path 16: 3 9 6 5 7 4 2 8 1 , Distance:  29.807383

Trial 10: 
GENERATION 798
 Path 1: 1 4 3 9 6 5 7 2 8 , Distance:  27.561860
 Path 2: 3 9 6 1 4 5 7 2 8 , Distance:  37.781405
 Path 3: 6 5 7 2 8 1 4 3 9 , Distance:  27.561860
 Path 4: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
 Path 5: 9 6 5 7 2 8 1 4 3 , Distance:  27.561860
 Path 6: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
 Path 7: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
 Path 8: 3 9 6 5 7 2 8 1 4 , Distance:  27.561860
 Path 9: 8 1 4 3 9 6 5 7 2 , Distance:  27.561860
Path 10: 6 5 7 2 8 1 4 3 9 , Distance:  27.561860
Path 11: 8 1 4 3 9 6 5 7 2 , Distance:  27.561860
Path 12: 7 2 8 1 4 3 9 6 5 , Distance:  27.561860
Path 13: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
Path 14: 2 8 1 4 3 9 6 5 7 , Distance:  27.561860
Path 15: 9 6 5 7 2 8 1 4 3 , Distance:  27.561860
Path 16: 6 5 7 2 8 1 4 9 3 , Distance:  28.097254