# Gym Log
Simple android app for logging gym activities/workouts.
For now, I'm thinking it will simply be a wrapper around a sqlite database.
Not really trying to make a product out of this, just trying to learn a little Java and Android for fun.

## Layout
Main Page
* Add workout (new Activity)
    * Recent workouts (horizontal scroll cards)
    * Favorite workouts (horizontal scroll cards)
    * All workouts
        * Vertical scroll list of workouts
    * New workout (add button?)
* View recent workouts (new Activity)
    * Recent workouts (vertical scroll)
* View statistics (new Activity)

## Things I learned

### Java
	* Why the hell does anyone define anything as private? Just trust people to do the right thing!
	* To convert from Unix epoch time to local time, use Instant.ofEpochMilli(), then pass this to LocalDateTime(instant, ZoneId.systemDefault()) (all these are defined in java.time)
	* Java has no concept of namespaces like python. You cannot have two objects with the same name or even redefine their names if there is a conflict.
	* No such thing as keyword arguments; need to define multiple constructors if you want to use different combinations of arguments
		* The one exception to this is `public Type1 func(Type2... t2) {}`, which will accept a variable number of Type2 objects

### Android
	* "Screens" are called "Activities"
	* You can send data between Activities using Intents; use the intent.putExtra() method to do so
	* The UI that you see is made up of View and Layout objects. You can either declare them statically in the xml files, or dynamically in java.
		* If you need to programatically alter something, findViewById() is your friend
	* There are so many objects and methods, it's ridiculous. Use your IDE's autocomplete to help you find what you're looking for

### Room Persistence Library
	* If you define your fields with primitive types (int, double, etc.), then they will be non-nullable by default. Use object types (Integer, Double, etc.) if you want nullable fields
	* SQL queries can only be run on background threads. If you run it on the main thread it will crash the app
		* You should wrap each query/insert/delete method using another class that handles all the threading for you so you don't have to worry about it
	* You can download the database using the Device File Explorer in Android Studio under data/data/your.project.package/databases, mess around with it manually, then reupload it by putting it in your 'assets' folder (Project > New > Folder > Assets Folder to make one from scratch). Seed your database by adding `.createFromAsset("file_path") to the database builder
	* You can't alter column types/names in SQLite after creating the table. Only option is to make a new table with the right info and `INSERT INTO new_table SELECT * FROM old_table`
