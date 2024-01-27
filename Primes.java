import java.time.Instant;
import java.util.ArrayList;
import java.time.Duration;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Primes{

	public static void main(String[] args) throws InterruptedException{
		
		FindPrimes prime1 = new FindPrimes(1, 12500000);
		FindPrimes prime2 = new FindPrimes(12500001, 25000000);
		FindPrimes prime3 = new FindPrimes(25000001, 37500000);
		FindPrimes prime4 = new FindPrimes(37500001, 50000000);
		FindPrimes prime5 = new FindPrimes(50000001, 62500000);
		FindPrimes prime6 = new FindPrimes(62500001, 75000000);
		FindPrimes prime7 = new FindPrimes(75000001, 87500000);
		FindPrimes prime8 = new FindPrimes(87500001, 100000000);

		Instant startTime = Instant.now();

		prime1.start();
		prime2.start();
		prime3.start();
		prime4.start();
		prime5.start();
		prime6.start();
		prime7.start();
		prime8.start();

		prime1.join();
		prime2.join();
		prime3.join();
		prime4.join();
		prime5.join();
		prime6.join();
		prime7.join();
		prime8.join();

		Instant endTime = Instant.now();

		Duration elapsedTime = Duration.between(startTime, endTime);
    
		int count= prime1.x + prime2.x +prime3.x +prime4.x +prime5.x +prime6.x +prime7.x +prime8.x;
		long sum= prime1.sum + prime2.sum +prime3.sum +prime4.sum +prime5.sum +prime6.sum +prime7.sum +prime8.sum;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
            // Write content to the file
            writer.write("Runtime: " + elapsedTime.toMillis() + " milliseconds\n");
            writer.write("Total number of primes found: " + count + "\n");
			writer.write("Sum of all primes found " + sum + "\n");
			writer.write("Top ten primes: " + prime8.pq.subList(prime8.pq.size()-10, prime8.pq.size()).toString());


        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}

class FindPrimes extends Thread{

	long sum;
	int n;
	int m;
	ArrayList<Integer> pq = new ArrayList<Integer>();
	int x;


	public FindPrimes(int n, int m){
		this.n = n;
		this.m = m;
	}

	public void run(){
		

		for(int i = n; i <= m; i++){
			if(isPrime(i)){
				sum += i;
				x++;
				pq.add(i);
			}
		}
	}

	public boolean isPrime(int n){

		if(n <= 1) return false;

		if(n == 2) return true;
		if(n%2 == 0) return false;


		for(int i = 3; i <= Math.sqrt(n); i++){
			
			if(n%i++ == 0) return false;
		}

		return true;
	}

}