TechSupport - the DodgySoft Technical support system, version #2.

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

This project is discussed in chapter 6.


This project implements a second version of the technical support system 
example. It is an intermediate version intended to demonstrate the first
few changes discussed in this book chapter.


To start this program, create a SupportSystem object and execute the "start" 
method.

Then start describing your problem by typing in the terminal window.

24-A HashMap in Java implements the Map interface, storing data as key-value pairs. It functions similarly to a dictionary: a key (like 'word') maps to a value (like 'definition').



25-
    * `put(K key, V value)` 
    * `get(Object key)` 
    * `containsKey(Object key)` 
    * `containsValue(Object value)` 
    * `remove(Object key)` 
    * `replace(K key, V value)` 
    * `equals(Object o)` 
    * `hashCode()` 
    Yes



26-To check the number of entries in a map you can use the `size` method in most programming languages.



27-x



28-Nothing much, just overwrites the previous one with the lastest.



29-Both exist



30-use containsKey()
    if bob has key that is "Johnny"
    then return bob.containsKey("Johnny");
    it will return true



31-it will return Null



32-make a for loop that will print out the the keySet one by one till all will be printed.



33-x



34-
Similarities:

Both HashSet and ArrayList store a collection of objects.

Both allow null elements (only one null in HashSet).

Both are part of the Java Collections Framework.

Differences:

HashSet (from Set) does not allow duplicates, while ArrayList (from List) allows duplicates.

HashSet has no guaranteed order, but ArrayList maintains insertion order.

ArrayList allows indexed access, HashSet does not.



35-Returning words in a HashSet removes duplicates and does not preserve order, while returning them in an ArrayList keeps duplicates and preserves the insertion order.



36-If there are multiple spaces between words and you split the text using .split(" "), it will create empty strings for the extra spaces, which can be a problem.



37-I made it using a mix of arrayList and HashMap. Uses split, verifies if input contains keys by splitting the input into words. Answers cannot be duplicate because of the use of the hashmap.



38-x



39-x



40-x



41-x



42-x


