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


``` SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                mEditor.putString(Name, name);
                mEditor.putString(Phone,pass);
                mEditor.putString(Email,email);
                mEditor.commit();
```
From the code above,We created the **sharedPreference.Editor**  by calling the __.editor__ method.
The added up all the strings using **PutString** and save all teh changes we use __commit__ method.

### screenshot

![sharedpref](https://user-images.githubusercontent.com/34624703/86350297-223a7380-bc6b-11ea-9791-1dadeb14a9ad.JPG)


### Delete and clear from sharedPreference
call the method **clear()** to clear and **.remove()** to delete data. make sure to pass in the correct key.

# Picasso Library 
a powerful library that allows you to load you images into your app with 1 if no 2 lines of code.

```Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);```

### Image Transfomation 
```Picasso.get()
  .load(url)
  .resize(50, 50)
  .centerCrop()
  .into(imageView)
```






