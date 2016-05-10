# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) PEER REVIEW
# You will be reviewing projects for **two** of your peers

## Why?
- You will provide your peers with valuable feedback for their cornerstone project.
- You will receive said valuable feedback from **two** peers as well - making your cornerstone project that much better.
- You will gain insight into issues you might have on your own project.
- You will learn how to provide a semi-formal code review. Code reviews **will** be part of your job, its important to learn how they work.


## Guide to giving peer feedback

### Forking the project and preparation:
- 1. Fork your peer's repo into your github account.
- 2. Create a new ```peer_review.md``` file on **your peer project fork**. 
- 3. Copy the contents of **this** file and **paste** them into ```peer_review.md``` file you created on **your fork**.

### Creating peer review pull request:
- 1. Now you should be able to create a **pull request** from your fork back to your peer's original repo.
- 2. Title the pull request with: ```Peer review: Your Name```.
- 3. In the comments section, copy each question from below and answer it!

### Questions to answer:
##### 1. Does the project appear to meet the technical requirements? **Write up one sentence on your findings and give a score 0-3.**
- Is your peer making API calls, using SDK's/third-party libraries?
Yes: the app is using two APIs from the New York Times via Retrofit with the Gson adapter. There is additional code to also use RxJava in one of the abstractions, but it is unused. 2/3
- Is your peer making use of Services? If so, are they offloading long tasks to a separate thread, i.e. AsyncTask, Runnable, IntentService, etc.
No; there is no advantage to using services for this app anyway. 2/3
- Is your peer making use of Fragments? If so, are they passing data from Fragment to Activity via interfaces? If not, why did absense of Fragments make sense?
Yes: some fragments do pass data back to the activity via interfaces. In addition, there's also some RecyclerViewAdapters that do as well.
 However, there are a few fragments that completely depend on the actual activity being their parent preventing abstraction. 1/3
- Is your peer making use of RecyclerView? If so, does it appear to be working correctly ( implementation and otherwise )?
Yes. 2/3
- Is your peer making use of some sort of persistent storage, i.e. Firebase or SQLite? If so, why do you think Firebase/SQLite was chosen? Could they have used one or the other instead and why?
Yes: SQLite is in use. There wouldn't be much benefit of using Firebase other than providing a user account to store the preferences at this stage. 2/3

##### 2. Does the project appear to be creative, innovative, and different from **any** competition? **Write up one sentence on your findings and give a score 0-3.**
- Is your peer making use of proper UX patterns we learned in class? If not, what are they doing that is unconvetional or that might confuse a user ( you )?
I would say the majority of the app fits within the guidelines; however, the screens containing a tab bar should match the app bar's color and in the main screen the dropdown is unconventional (maybe use a tab bar here too).
- Is your peer making anything cool or awesome that you would like to note or applaud them on?

##### 3. Does the project appear to follow correct coding styles and best practices? **Write up one sentence on your findings and give a score 0-3.**
- Are you able to reasonably follow the code without having anyone answer your questions?
Yes. 2/3
- Are you able to make sense of what the code is doing or is trying to do?
Sort of. There is a lot of dead code, and a lot of duplicated code. Some code can be massively compacted. 1/3

##### 4. Find two pieces of code of any size: one that is ```readable and easy to follow``` and one that is ```difficult to follow and understand```.
- What makes the readable code readable? **Be as detailed as you can in your answer, it can be challenging to explain why something is easy to undertand**
```java
Observable<NytSportsResults> observable = nytSports.nytSportsResults("all", "sports", NYT_ALL);

observable.subscribeOn(Schedulers.newThread())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new Subscriber<NytSportsResults>() {
        @Override
        public void onCompleted() {
            Log.d("MainActivity", "Completed!");
    
        }
    
        @Override
        public void onError(Throwable e) {
            Timber.e(e.getMessage());
        }
    
        @Override
        public void onNext(NytSportsResults nytSportsResults) {
            Log.d("MainActivity", "Next!");
            if (recyclerViewIsSet) {
                allSportsAdapter.updateData(nytSportsResults);
    
            } else {
                allSportsAdapter.updateData(nytSportsResults);
                recyclerView.setAdapter(allSportsAdapter);
                recyclerViewIsSet = true;
            }
            Collections.addAll(sportsNewsList, nytSportsResults.getResults());
            swipeContainer.setRefreshing(false);
        }
    });
```
I like how you're using RxJava here. The variable names are clear and make it obvious what this code does.
- What makes the difficult code harder to follow? **Be as detailed as you can in your answer**.
```java
textView.setText(getString(R.string.german_records_title1).toUpperCase() + "\n" +
getString(R.string.german_records_title2) + "\n" +
getString(R.string.german_records1) + "\n" +
getString(R.string.german_records_title3) + "\n" +
getString(R.string.german_records2) + "\n" +
getString(R.string.german_records_title4) + "\n" +
getString(R.string.german_records3) + "\n" +
getString(R.string.german_records_title5) + "\n" +
getString(R.string.german_records4) + "\n" +
getString(R.string.german_records_title6) + "\n" +
getString(R.string.german_records5) + "\n" +
getString(R.string.german_records_title7) + "\n" +
getString(R.string.german_records_title8) + "\n" +
getString(R.string.german_records6) + "\n" +
getString(R.string.german_records_title9) + "\n" +
getString(R.string.german_records7) + "\n" +
getString(R.string.top_scorers_title).toUpperCase() + "\n" +
getString(R.string.german_records_10));
```
This probably should be defined using string arrays rather than hard-coding each string to code reference.

##### 5. High level project overview: Take a look at as many individual files as you have time for
- Does this class make sense? 
- Does the structure of the class make sense?
- Is it clear what this class is supposed to do?
