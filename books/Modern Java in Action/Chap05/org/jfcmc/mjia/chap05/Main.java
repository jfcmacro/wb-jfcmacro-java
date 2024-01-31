package org.jfcmc.mjia.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Main {

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

	List<String> threeHighCaloricDishNames =
	    menu.stream()
	    .filter(dish -> dish.getCalories() > 300)
	    .map(Dish::getName)
	    .limit(3)
	    .collect(toList());

	System.out.println(threeHighCaloricDishNames);

	List<Dish> vegetarianDishes =
	    menu.stream()
	    .filter(Dish::isVegetarian)
	    .collect(toList());

	System.out.println(vegetarianDishes);

	// Section 5.1. Filtering
	List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);

	numbers.stream()
	    .filter(i -> i % 2 == 0)
	    .distinct()
	    .forEach(System.out::println);

	// Section 5.2. Slicing
	List<Dish> specialMenu =
	    Arrays.asList(new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
			  new Dish("prawns", false, 300, Dish.Type.FISH),
			  new Dish("rice", true, 350, Dish.Type.OTHER),
			  new Dish("chicken", false, 400, Dish.Type.MEAT),
			  new Dish("french fries", true, 530, Dish.Type.OTHER));

	Predicate<Dish> pd = dish -> dish.getCalories() < 320;

	List<Dish> filteredMenu =
	    specialMenu.stream().takeWhile(pd).collect(toList());

	System.out.println("Filtered Menu: " + filteredMenu);

	List<Dish> slicedMenu2 =
	    specialMenu
	    .stream()
	    .dropWhile(pd)
	    .collect(toList());

	System.out.println("SlicedMenu2: " + slicedMenu2);

	Predicate<Dish> pdGT300 = dish -> dish.getCalories() > 300;

	List<Dish> dishes =
	    specialMenu
	    .stream()
	    .filter(pdGT300)
	    .limit(2)
	    .collect(toList());

	System.out.println("Dishes: " + dishes);

	List<Dish> dishesSkip =
	    specialMenu
	    .stream()
	    .filter(pdGT300)
	    .skip(2)
	    .collect(toList());

	System.out.println("Dishes Skip(2): " + dishesSkip);

	Predicate<Dish> pdMeat = dish -> dish.getType() == Dish.Type.MEAT;

	// 5.3 Mapping

	List<String> dishNames =
	    menu.stream()
	    .map(Dish::getName)
	    .collect(toList());

	System.out.println("Dish names: " + dishNames);

	List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

	List<Integer> wordsLengths =
	    words.stream()
	    .map(String::length)
	    .collect(toList());

	System.out.println("Words lengths: " + wordsLengths);

	// Flattening streams

	List<String> uniqueCharacters =
	    words.stream()
	    .map(word -> word.split(""))
	    .flatMap(Arrays::stream)
	    .distinct()
	    .collect(toList());

	System.out.println("Unique Characters: " +
			   uniqueCharacters);

	List<String> uniqueCharacters2 =
	    words.stream()
	    .map(word -> word.split(""))
	    .flatMap(Arrays::stream)
	    .map(String::toLowerCase)
	    .distinct()
	    .collect(toList());

	System.out.println("Unique Characters2: " +
			   uniqueCharacters2);

	// Quiz 5.2 Mapping
	List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

	Function<Integer,Integer> fsq = i -> i * i;
	List<Integer> squares =
	    nums.stream()
	    .map(fsq)
	    .collect(toList());

	System.out.println("squares: " +
			   squares);

	class Pair {
	    Integer fst;
	    Integer snd;
	    Pair(Integer fst, Integer snd) {
		this.fst = fst;
		this.snd = snd;
	    }
	    @Override
	    public String toString() {
		return "(" + fst.toString() + "," +
		    snd.toString() + ")";
	    }
	}

	// List<Pair> sqr2 =
	//     nums.stream()
	//     .map(i -> new Pair(i, fsq.apply(i)))
	//     .collect(toList());

	// System.out.println("sqr2: " + sqr2);

	List<Integer> lst1 = Arrays.asList(1,2,3);
	List<Integer> lst2 = Arrays.asList(3, 4);

	List<Pair> concatToList =
	    lst1.stream()
	    .flatMap(i -> lst2.stream()
		     .map(j -> new Pair(i,j)))
	    .collect(toList());

	System.out.println("concatToList: " +
			   concatToList);

	List<Pair> sqr3 =
	    nums.stream()
	    .map(i -> new Pair(i, fsq.apply(i)))
	    .filter(p -> p.snd % 3 == 0)
	    .collect(toList());

	System.out.println("sqr2: " + sqr3);

	// Section 5.4

	if (menu.stream().anyMatch(Dish::isVegetarian)) {
	    System.out.println("The menu is (somewhat) vegetarian friendly");
	}

	if (menu.stream().allMatch(d -> d.getCalories() < 1000)) {
	    System.out.println("It looks that it's low calories");
	}

	if (menu.stream().noneMatch(d -> d.getCalories() >= 1000)) {
	    System.out.println("It looks that it is healthy");
	}

	menu
	    .stream()
	    .filter(Dish::isVegetarian)
	    .findAny()
	    .ifPresent(dish -> System.out.println(dish.getName()));

	Random r = new Random(System.currentTimeMillis());

	List<Integer> lstNmbrs =
	    Stream.iterate(1, i -> i < 100, i -> i + 1)
	    .map(n -> Integer.valueOf(Math.abs(r.nextInt()) % 100))
	    .collect(toList());

	Optional<Integer> firstDivisibleByThree =
	    lstNmbrs.stream()
	    .map(n -> n * n)
	    .filter(n -> n % 3 == 0)
	    .findFirst();

	System.out.println(firstDivisibleByThree);

	// Section 5.5

	// Quiz 5.3

	System.out.println("Numbers of dishes: " +
			   menu
			   .stream()
			   .map(i -> 1)
			   .reduce((a,b) -> a + b)
			   .orElse(0));

    }

}
