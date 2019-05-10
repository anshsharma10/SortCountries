import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * The SortCountries class. Will take a list of countries their respective populations and sort them alphabetically 
 * and by population.
 * @author Ansh Sharma, Nabiha Islam
 * @version 1 2019.04.03
 */

public class SortCountries {
  
  /**
 * <b>Global variables: </b>
 * <p>
 * <b>couuntries</b> Array list containing all of the country names (String).
 * <p>
 * <b>capitals</b> Array list containing all of the capital city names (String).
 * <p>
 * <b>area</b> Array list containing all of the countries' areas (int).
 * <p>
 * <b>pop</b> Array list containing all of the countries' populations (int).
 */ 
  
  static ArrayList<String> countries = new ArrayList<String>(); 
  static ArrayList<String> capitals = new ArrayList<String>();
  static ArrayList<Integer> area = new ArrayList<Integer>();
  static ArrayList<Integer> pop = new ArrayList<Integer>();
  
  /**
 * The class constructor has no parameters and does not perform any actions. It is used to create a SortCountries object.
 */ 
  public SortCountries() { 
    
  }
  
  /**
 * The outputCountry method will output country names and their populations into a .txt file, sorted by name.
 */ 
  public void outputCountry() { 
    try {
      PrintStream stream = new PrintStream( "sortedByCountry.txt" );//outputs to a text file
      for (int i = 0; i < pop.size(); i++) {
        stream.println(countries.get(i) + "\t\t\t" + pop.get(i));//prints each country and its population
      }
    }
    catch (Exception e) {
    }
  }
  
  /**
 * The outputPop method will output country names and their populations into a .txt file, sorted by population.
 */ 
  public void outputPop() {
    try {
      PrintStream stream = new PrintStream( "sortedByPopulation.txt" );//outputs to a text file
      for (int i = 0; i < pop.size(); i++) {
        stream.println(countries.get(i) + "\t\t\t" + pop.get(i));//prints each country and its population
      }
    }
    catch (Exception e) {
      
    }
  }
  
  /**
 * The sortByCountry method will sort the countries array in alphabetical order using selection sort.
 * <p>
 * <b>Local variables: </b>
 * <p>
 * <b>n</b> Represents the size of the countries array.
 * <p>
 * <b>maxPos</b> Represents the position of the highest element in the countries array.
 * <p>
 * <b>temp1</b> Temporary integer to store a given population from the array.
 * <p>
 * <b>temp2</b> Temporary integer to store a given area from the array.
 * <p>
 * <b>temp3</b> Temporary String to store a given capital city name from the array.
 * <p>
 * <b>temp4</b> Temporary String to store a given country name from the array.
 */ 
  public void sortByCountry() {
    int n = countries.size();
    while (n > 1) {//while the loop does not exceed the array size
      int maxPos = 0;
      for (int k = 1; k < n; k++)
        if (countries.get(k).compareTo(countries.get(maxPos)) > 0 )
        maxPos = k;//sets the max position to the given element 
      //temporary variables to store values
      int temp1 = pop.get(maxPos);
      int temp2 = area.get(maxPos);
      String temp3 = capitals.get(maxPos);
      String temp4 = countries.get(maxPos);
      pop.set(maxPos,pop.get(n-1));//sets the max value to the given element
      pop.set(n-1,temp1);//sets the previous max value to the given element
      area.set(maxPos,area.get(n-1));//sets the max value to the given element
      area.set(n-1,temp2);//sets the previous max value to the given element
      capitals.set(maxPos,capitals.get(n-1));//sets the max value to the given element
      capitals.set(n-1,temp3);//sets the previous max value to the given element
      countries.set(maxPos,countries.get(n-1));//sets the max value to the given element
      countries.set(n-1,temp4);//sets the previous max value to the given element
      n--;//subtracts 1 from the amount of times the loop needs to be run
    }
  }
  
  
  /**
 * The sortByPop method will sort the countries array in order from highest population to the lowest using selection 
 * sort.
 * <p>
 * <b>Local variables: </b>
 * <p>
 * <b>n</b> Represents the size of the population array.
 * <p>
 * <b>maxPos</b> Represents the position of the highest element in the population array.
 * <p>
 * <b>temp1</b> Temporary integer to store a given population from the array.
 * <p>
 * <b>temp2</b> Temporary integer to store a given area from the array.
 * <p>
 * <b>temp3</b> Temporary String to store a given capital city name from the array.
 * <p>
 * <b>temp4</b> Temporary String to store a given country name from the array.
 */ 
  public void sortByPop() {
    int n = pop.size();
    while (n > 1) {//while the loop does not exceed the array size
      int maxPos = 0;
      for (int k = 1; k < n; k++)
        if (pop.get(k) < pop.get(maxPos) )
        maxPos = k;//sets the max position to the given element 
      //temporary variables to store values
      int temp1 = pop.get(maxPos);
      int temp2 = area.get(maxPos);
      String temp3 = capitals.get(maxPos);
      String temp4 = countries.get(maxPos);
      pop.set(maxPos,pop.get(n-1));//sets the max value to the given element
      pop.set(n-1,temp1);//sets the previous max value to the given element
      area.set(maxPos,area.get(n-1));//sets the max value to the given element
      area.set(n-1,temp2);//sets the previous max value to the given element
      capitals.set(maxPos,capitals.get(n-1));//sets the max value to the given element
      capitals.set(n-1,temp3);//sets the previous max value to the given element
      countries.set(maxPos,countries.get(n-1));//sets the max value to the given element
      countries.set(n-1,temp4);//sets the previous max value to the given element
      n--;//subtracts 1 from the amount of times the loop needs to be run
    }
  }
  
  /**
 * The inputCountries method will read countries from a text file and call the sort and output methods to create two 
 * new text files: one sorted alphabetically, and one sorted in order of population size. It will read all of the 
 * lines and first determine if the country/capital is "special", meaning if it has spaces in its name or not. If not, 
 * it will find and store the country name, capital city, area, and population into their respective arrays by finding 
 * where the spaces are.
 * <p>
 * <b>Local variables: </b>
 * <p>
 * <b>input</b> Reads lines from the countries-populations.txt file.
 * <p>
 * <b>specialCountries</b> Array that stores countries with names that do not fit the standard naming conventions 
 * (has spaces in the name).
 * <p>
 * <b>specialCapitals</b> Array that stores capital cities with names that do not fit the standard naming conventions 
 * (has spaces in the name).
 * <p>
 * <b>areaLocation</b> Index location of area number.
 * <p>
 * <b>popLocation</b> Index location of population number.
 * <p>
 * <b>specialCountry</b> Boolean to check if the country is a special country.
 */
  public void inputCountries() {
    try { 
      Scanner sc = new Scanner(new File("countries-populations.txt"));  
      String[] specialCountries = {"Andorra","Antigua and Barbuda","Argentina","Belarus","Bolivia","Bosnia and Herzegovina","Brunei","Burkina","Cambodia","Cape Verde","Central African Republic","Congo, Republic of","Congo, Democratic Republic of","Costa Rica","Côte d'Ivoire","Czech Republic","Dominican Republic","East Timor","El Salvador","Equatorial Guinea","Ethiopia","Grenada","Guatemala","Guinea-Bissau","India","Korea, North","Korea, South","Kuwait","Malaysia","Marshall Islands","Mauritius","Mexico","Mongolia","Myanmar","Panama","Papua New Guinea","St. Kitts and Nevis","St. Lucia","St. Vincent and the Grenadines","San Marino","São Tomé and Príncipe","Saudi Arabia","Sierra Leone","Solomon Islands","South Africa","Sri Lanka","Trinidad and Tobago","Ukraine","United Arab Emirates","United Kingdom","United States","Vatican"};
      String[] specialCapitals = {"Andorra la Vella","St. John's","Buenos Aires","Mensk (Minsk)","La Paz","Sarajevo","Bandar Seri Begawan","Faso Ouagadougou","Phnom Penh","Praia","Bangui","Republic of Brazzaville","Kinshasa","San José","Yamoussoukro","Prague","Santo Domingo","Dili","San Salvador","Guinea Malabo","Addis Ababa","St. George's","Guatemala City","Bissau","New Delhi","North Pyongyang","Seoul","Kuwait City","Kuala Lumpur","Majuro","Port Louis","Mexico City","Ulan Bator","Rangoon","Panama City","Port Moresby","Basseterre","Castries","Kingstown","San Marino","São Tomé","Riyadh","Freetown","Honiara","Pretoria","Columbo","Port-of-Spain","Kyiv (Kiev)","Abu Dhabi","London","Washington","Vatican City"};
      while(sc.hasNext()){     
        String input = sc.nextLine();   
        int areaLocation = 0; 
        int popLocation = 0;
        boolean specialCountry = false; //if it is not a special country
        try {
          for (int i = 0; i < input.length(); i++) { 
            try {
              areaLocation = Integer.parseInt("" + input.charAt(i));
              areaLocation = i;//finds the index location of area
              popLocation = input.substring(areaLocation).indexOf(" ") + areaLocation;//finds the location of population based on area location
              break;
            }
            catch (Exception e){}
          }
          for (int i = 0; i < specialCountries.length; i++) {
            if (input.indexOf(specialCountries[i]) != -1) {
              countries.add(specialCountries[i]); //adds the country to the array for special countries
              capitals.add(specialCapitals[i]); //adds the country to the array for special capitals
              String temp = "";
              for (int j = areaLocation; j < popLocation; j++) { 
                if (input.charAt(j) == ',') {
                  j++;
                }
                temp = temp + input.charAt(j);
              }
              area.add(Integer.parseInt(temp));
              temp = "";
              for (int j = popLocation + 1; j < input.length(); j++) { 
                if (input.charAt(j) == ',') {
                  j++;
                } else if (input.charAt(j) == ' ') {//if there is a space in the name
                  j++;
                } else {
                  temp = temp + input.charAt(j);
                }
              }
              pop.add(Integer.parseInt(temp));
              specialCountry = true;//it is a special country if there are spaces in the names
            }
          }
          if (specialCountry == false) { //if it is not a special country
            int capitalLocation = input.substring(0,areaLocation).indexOf(" "); //the capital city is found by finding the space after the country name
            countries.add(input.substring(0, capitalLocation));//adds to country array
            capitals.add(input.substring(capitalLocation,areaLocation)); //adds to capital array
            String temp = "";
            for (int j = areaLocation; j < popLocation; j++) { 
              if (input.charAt(j) == ',') {
                j++;
              }
              temp = temp + input.charAt(j);
            }
            area.add(Integer.parseInt(temp));//adds the area to the area array
            temp = "";
            for (int j = popLocation + 1; j < input.length(); j++) { 
              if (input.charAt(j) == ',') {
                j++;
              } else if (input.charAt(j) == ' ') {
                j++;
              } else {
                temp = temp + input.charAt(j);
              }
            }
            pop.add(Integer.parseInt(temp));
          }
        }
        catch (Exception e) {
          System.out.println(e);
        }
      }
    }
    catch (Exception e){
    }
    
    //calls each sort and output method to create two sorted .txt files
    sortByPop();
    outputPop();
    sortByCountry();
    outputCountry();
  }
  
  /**
 * Main method.
 */ 
  public static void main (String [] args){
    SortCountries test = new SortCountries();
    test.inputCountries();
  }
}