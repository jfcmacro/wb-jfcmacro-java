package org.jfcmc.mjia.chap06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import static java.lang.Math.sqrt;
import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

public class Main {

    public static boolean isPrime(int candidate) {
	return IntStream.range(2, candidate)
	    .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrime2(int candidate) {
	int candidateRoot = (int) sqrt((double) candidate);
	return IntStream.rangeClosed(2, candidateRoot)
	    .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
	return IntStream.rangeClosed(2,n).boxed()
	    .collect(partitioningBy(Main::isPrime2));
    }

    public static void main(String...args) {
	List<Dish> menu =
	    Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			  new Dish("beef", false, 700, Dish.Type.MEAT),
			  new Dish("chicken", false, 400, Dish.Type.MEAT),
			  new Dish("french fries", true, 530, Dish.Type.OTHER),
			  new Dish("rice", true, 350, Dish.Type.OTHER),
			  new Dish("season fruit", true, 120, Dish.Type.OTHER),
			  new Dish("pizza", true, 550, Dish.Type.OTHER),
			  new Dish("prawns", false, 300, Dish.Type.FISH),
			  new Dish("salmon", false, 450, Dish.Type.FISH));

	// Section 6.2 Reducing and summarizing
	System.out.printf("Counting method collect: %s count: %s%n",
			  menu.stream().collect(counting()),
			  menu.stream().count());

	// Section 6.2.1 Fiding maximum and minimum
	Comparator<Dish> dishCaloriesComparator =
	    Comparator.comparingInt(Dish::getCalories);

	Optional<Dish> mostCaloriesDish =
	    menu.stream().collect(maxBy(dishCaloriesComparator));

	mostCaloriesDish
	    .ifPresentOrElse(d ->
			     System.out.printf("The Dish with the most highest calories: %s%n", d),
			     () -> System.out.printf("There are not dishes %n"));

	// Section 6.2.2 Summarization
	int totalCalories1 =
	    menu.stream().mapToInt(Dish::getCalories).sum();

	int totalCalories2 =
	    menu.stream().collect(summingInt(Dish::getCalories));

	System.out.printf("Total calories method1: %d calories method2: %d%n",
			  totalCalories1, totalCalories2);

	double avgCalories =
	    menu.stream().collect(averagingInt(Dish::getCalories));

	System.out.printf("Averange of menu's calories: %2.2f%n",
			  avgCalories);

	IntSummaryStatistics menuStatisticsCalories =
	    menu.stream().collect(summarizingInt(Dish::getCalories));

	System.out.printf("Menu statistics: %s%n",
			  menuStatisticsCalories);

	int totalCalories3 =
	    menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();

	System.out.println("Total Calories by using reduce: " + totalCalories3);

	int totalCalories4 =
	    menu.stream().mapToInt(Dish::getCalories).sum();

	System.out.println("Total Calories by using IntStream: " + totalCalories4);

	// Section 6.2.3 Joining Strings
	String shortMenu = menu.stream().map(Dish::getName).collect(joining());
	// The next doesn't working
	// String shortMenu2 = menu.stream().collect(joining());
	System.out.printf("Short menu: %s%n", shortMenu);

	String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));

	System.out.printf("Short menu (commas): %s%n",
			  shortMenu2);

	// Section 6.2.4 Generalizing Reduction
	int totalCaloriesReducing =
	    menu.stream().collect(reducing(0, Dish::getCalories, (i,j) -> i + j));

	System.out.printf("Using collect and reducing method total calories: %d%n",
			  totalCaloriesReducing);

	Optional<Dish> mostCalorieDish =
	    menu.stream().collect(reducing((d1,d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

	mostCaloriesDish
	    .ifPresentOrElse(d -> System.out.printf("Dish with most Calories %s%n", d),
			     () -> System.out.printf("Dis with most Calories wasn't found%n"));

	// Section 6.3 Grouping
	Map<Dish.Type, List<Dish>> dishesByType =
	    menu.stream().collect(groupingBy(Dish::getType));

	System.out.println("Dishes grouping by type: " + dishesByType);

	enum CaloricLevel { DIET, NORMAL, FAT };
	Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =
	    menu.stream().collect(groupingBy(dish -> {
		    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
		    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
		    else return CaloricLevel.FAT;
		    }));

	System.out.println("Caloric Level: " + dishesByCaloricLevel);

	// Section 6.3.1 Manipulating grouped elements

	Map<Dish.Type, List<Dish>> caloricDishesByType =
	    menu.stream()
	    .filter(dish -> dish.getCalories() > 500)
	    .collect(groupingBy(Dish::getType));

	System.out.println("This version doesn't include the FISH category");
	System.out.println("Caloric Dishes By Type: " +
			   caloricDishesByType);

	Map<Dish.Type, List<Dish>> caloricDishesByType2 =
	    menu.stream()
	    .collect(groupingBy(Dish::getType,
				filtering(dish -> dish.getCalories() > 500, toList())));

	System.out.println("This versions includes the FISH category");
	System.out.println("Caloric Dishes By Type: " +
			   caloricDishesByType2);

	Map<Dish.Type, List<String>> dishNamesByTypes =
	    menu.stream()
	    .collect(groupingBy(Dish::getType,
				mapping(Dish::getName, toList())));

	System.out.println("Dish Names By Types: " +
			   dishNamesByTypes);


	Map<String, List<String>> dishTags = new HashMap<>();

	dishTags.put("pork", asList("greasy", "salty"));
	dishTags.put("beef", asList("salty", "roasted"));
	dishTags.put("chicken", asList("fried", "crisp"));
	dishTags.put("french fries", asList("greasy", "salty"));
	dishTags.put("rice", asList("light", "natural"));
	dishTags.put("season fruit", asList("fresh", "natural"));
	dishTags.put("pizza", asList("tasty", "salty"));
	dishTags.put("prawns", asList("tasty", "roasted"));
	dishTags.put("salmon", asList("delicious", "fresh"));

	Map<Dish.Type, Set<String>> dishNamesByType =
	    menu.stream()
	    .collect(groupingBy(Dish::getType,
				flatMapping(dish -> dishTags.get(dish.getName()).stream(),
					    toSet())));

	System.out.println("Dish Names By Type: " +
			   dishNamesByType);

	// 6.3.2 Multilevel grouping

	Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
	    menu.stream()
	    .collect(groupingBy(Dish::getType,
				groupingBy(dish -> {
					if (dish.getCalories() <= 400)
					    return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
					    return CaloricLevel.NORMAL;
					else
					    return CaloricLevel.FAT;
				    })
				)
		     );

	System.out.println("Multilevel grouping: " +
			   dishesByTypeCaloricLevel);

	// 6.3.3 Collecting data in subgroups

	Map<Dish.Type, Long> typesCount =
	    menu.stream().collect(groupingBy(Dish::getType,
					     counting()));

	System.out.println("Types Count: " + typesCount);

	Map<Dish.Type, Optional<Dish>> mostCaloricByType =
	    menu.stream().collect(groupingBy(Dish::getType,
					     maxBy(comparingInt(Dish::getCalories))));

	System.out.println("Most Caloric By Type" +
			   mostCaloricByType);

	Map<Dish.Type, Dish> mostCaloricByTypeAdjusted =
	    menu.stream().collect(groupingBy(Dish::getType,
					     collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
							       Optional::get)));

	System.out.println("Most Caloric By Type Adjusted: " +
			   mostCaloricByTypeAdjusted);

	Map<Dish.Type, Integer> totalCaloriesByType =
	    menu.stream().collect(groupingBy(Dish::getType,
					     summingInt(Dish::getCalories)));

	System.out.println("Get total calories by type: " +
			   totalCaloriesByType);

	Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
	    menu.stream().collect(groupingBy(Dish::getType,
					     mapping(dish -> {
						     if (dish.getCalories() <= 400)
							 return CaloricLevel.DIET;
						     else if (dish.getCalories() <= 700)
							 return CaloricLevel.NORMAL;
						     else
							 return CaloricLevel.FAT;
						 },
						 toSet())));

	System.out.println("Caloric Levels ByType " +
			   caloricLevelsByType);

	Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType2 =
	    menu.stream().collect(groupingBy(Dish::getType,
					     mapping(dish -> {
						     if (dish.getCalories() <= 400)
							 return CaloricLevel.DIET;
						     else if (dish.getCalories() <= 700)
							 return CaloricLevel.NORMAL;
						     else
							 return CaloricLevel.FAT;
						 },
						 toCollection(HashSet::new))));

	System.out.println("Caloric Levels ByType " +
			   caloricLevelsByType2);


	// 6.4 Partition

	Map<Boolean, List<Dish>> partitionedMenu =
	    menu.stream().collect(partitioningBy(Dish::isVegetarian));

	System.out.println("PartitionedMenu: " +
			   partitionedMenu);
	System.out.println("Vegetarian dishes: " +
			   partitionedMenu.get(true));
	System.out.println("No vegetarian dishes: " +
			   partitionedMenu.get(false));

	List<Dish> vegetarianDishes =
	    menu.stream().filter(Dish::isVegetarian).collect(toList());

	System.out.println("Vegetarian dishes: " +
			   vegetarianDishes);

	// 6.4.1 Advantages of partitioning

	Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
	    menu.stream().collect(partitioningBy(Dish::isVegetarian,
						 groupingBy(Dish::getType)));

	System.out.println("Vegetarian Dishes By Type: " +
			   vegetarianDishesByType);

	Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
	    menu.stream().collect(partitioningBy(Dish::isVegetarian,
						 collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
								   Optional::get)));

	System.out.println("Most Caloric Partitioned by Vegetarian or not: "
			   + mostCaloricPartitionedByVegetarian);

	// 6.4.2 Partitioning numbers into prime and non prime

	// System.out.println("Primes number 2..100");
	// IntStream.range(2,100).filter(Main::isPrime).forEach(System.out::println);
	// System.out.println("Primes number 2..1000");
	// IntStream.range(2,1000).filter(Main::isPrime).forEach(System.out::println);
	Map<Boolean, List<Integer>> partitionPrimesAndNoPrimes = partitionPrimes(100);
	System.out.println("List of primes: " + partitionPrimesAndNoPrimes.get(true));

	// 6.5 The Collector interface

	// 6.5.1 Making sense of the methods declared by Collector interface

	
    }
}
