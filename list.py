#!/usr/bin/python
#import modules used here -- sys is a very standard one
import sys
# Gather our code in a main() function
def main():
	list=[1,2,3,4,5,6,7,8,9,0]
	print list[3:5]
	list[3]="EBA"
	print list[0:]
	print list*2
	list=list*2
	print list
	list=list+["ossrc"]
	print list
# Command line args are in sys.argv[1], sys.argv[2] ...    
# sys.argv[0] is the script name itself and can be ignored
# Standard boilerplate to call the main() function to begin
# the program.

if __name__ == '__main__':
	main()
