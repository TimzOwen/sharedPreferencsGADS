# sharedPreferencsGADS
Google Africa Android workshop on shared preference 

## SharedPreference 

This is on of the most awesome Data Storage Android provides. It provides a way in which one can store and 
retrieve small amount of data in the form of key-values pairs. (primitive data types: __integer__, __float__, __boolean__, __string__, __long__)

### handling shared preference
In the case of **single** files we use __getPreference__ to get the values 
For the case of **Multiple** files we use __getSharedPreference__ and pass the file name as the parameter

### Initialize the shared preference on the context Activity
In our activity make sure to initialize the shared preference 

```SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);```

For the case of __multiple__ shared preference:
```SharedPreferences sharedPref = getSharedPreferences("FileName",Context.MODE_PRIVATE);```

__.MODE_Private__ makes sure we only access the files within our application.
__FileName__ is the file to be accessed only.

## Writing to shared preference:
We will need an **editor** to save and retrieve changes made to shared preference


