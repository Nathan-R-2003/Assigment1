My approach was to divide the numbers from 1 to 10^8 in 8 sections and have each thread verify the numbers in the sections corresponding to them. I skipped the even numbers except for 2, so I only had to verify 50,000,000 numbers.
To verify if a number n is prime, I checked all numbers bewteen 1 and sqrt(n) to see if n was divisible by any of those numbers. If it was then it wasn't prime. This approach doesn't fail because by looking for up to sqrt(n) we can tell if n has at least one other multiple other than 1 and itself without fail.
The program is efficient because dividing the numbers in 8 sections and then skipping the even numbers means that insead of having a single thread verigy 100 million numbers, I only needed to verify 6.25 million numbers per thread with 8 threads running at the same time which is way faster. 
For testing purposes. I ran 1 thread to test all the numbers and it took 90 seconds on average. With the 8 threads running concurrently the runtime went down to 15 seconds on average (tested on eustis3).  

To run this program from the command line, access the folder where the file (Primes.java) is located using the cd command.
Once in the folder, enter the command javac Primes.java to compile the file.
Then enter java Primes to run the file. 
A primes.txt file with the output should appear on the folder.