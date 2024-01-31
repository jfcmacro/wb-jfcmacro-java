package org.jfcmc.mjia.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import static java.util.stream.Collectors.toList;

public class Main2 {

    public static void main(String...args) {
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario", "Milan");
	Trader alan = new Trader("Alan", "Cambridge");
	Trader brain = new Trader("Brian", "Cambridge");

	List<Transaction> transactions =
	    Arrays.asList(new Transaction(brain, 2011, 300),
			  new Transaction(raoul, 2012, 1000),
			  new Transaction(raoul, 2011, 400),
			  new Transaction(mario, 2012, 710),
			  new Transaction(mario, 2012, 700),
			  new Transaction(alan, 2012, 950));

	// Query 1. Find all transactions in the year 2011
	//          and sort them by value (small to high)
	List<Transaction> trans2011 =
	    transactions.stream()
	    .filter(t -> t.getYear() == 2011)
	    .sorted((t1,t2) -> t1.getValue() - t2.getValue()) // .sorted(comparing(Transaction::getValue))
	    .collect(toList());

	System.out.println("All transactions 2011:" + trans2011);

	// Query 2. What are all the uniques cities where the traders work?
	List<String> uniqueCities =            // Set<String>
	    transactions.stream()
	    .map(Transaction::getTrader) // map(t -> t.getTrader().getCity())
	    .map(Trader::getCity)
	    .distinct()                  // .collect(toSet());
	    .collect(toList());

	System.out.println("Cities: " + uniqueCities);

	// Query 3. Find all traders from Cambridge and sort them by name.
	List<Trader> camTraders =
	    transactions.stream()
	    .map(Transaction::getTrader)
	    .filter(t -> t.getCity().equals("Cambridge"))                // .distinct()
	    .sorted((tr1,tr2) -> tr1.getName().compareTo(tr2.getName())) // .sorted(comparing(Transaction::getName))
	    .distinct()
	    .collect(toList());                                          //

	System.out.println("Cambridge Traders: " +
			   camTraders);

	// Query 4. Return a string of traders' names sorted alphabetically
	String allTradersOrdered =
	    transactions.stream()
	    .map(Transaction::getTrader)                                  // .map(t -> t.getTrader().getName())
	    .sorted((tr1,tr2) -> tr1.getName().compareTo(tr2.getName()))  // .distinct()
	    .map(Trader::getName)                                         // .sorted()
	    .distinct()                                                   // # get rid
	    .reduce("",(n1,n2) -> {                                       // .reduce(joining())
		    if (n1.length() == 0) return n2;
		    else return  n1 + "," + n2;
		});

	System.out.println("Traders: " + allTradersOrdered);

	// Query 5. Are any traders based in Milan
	Boolean thereAreAnyTraderBaseInMilan =
	    transactions.stream()
	    .map(Transaction::getTrader)
	    .map(Trader::getCity)
	    .anyMatch(t -> t.equals("Milan"));   // .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

	System.out.println("Are trades based in Milan: " +
			   thereAreAnyTraderBaseInMilan);

	// Query 6. Print the values of all transactions
	int total =                                                    // void
	    transactions.stream()
	    .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
	    .mapToInt(Transaction::getValue)
	    .sum();                                                    // forEach(System.out::println)

	System.out.println("Total transaction: " + total);

	// Query 7. What is the highest value of all the transactions

	OptionalInt opMax =
	    transactions.stream()
	    .mapToInt(Transaction::getValue)
	    .max();

	// Optional<Integer> opMax =
	//     transctions.stream()
	//     .map(Transaction::getValue)
	//     .reduce(Integer::max);

	System.out.println("Max value of all transactions: " + opMax.orElse(-1));

	// Query 8. Find the transaction with the smallest value

	Optional<Transaction> minTransac =
	    transactions.stream()
	    .min((tr1, tr2) -> tr2.getValue() - tr1.getValue()); // .min(comparing(Transaction::getValue))

	if (minTransac.isPresent()) {
	    System.out.println("Transaction with the smallest value is: " +
			       minTransac.get());
	}
	else {
	    System.out.println("There are not transactions at all");
	}
    }
}
