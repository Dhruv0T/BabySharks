/*
 * Problem 2.3.1 Sell My Pet Food
 */
public class TargetedAd {

  public static void main(String[] args)
  {
    /*  
     * TODO:
     * PREPARATION WORK
     * (1) Create a file called targetWords.txt. Populate this file with words on each line that
     *     you think would determine if a user is a dog or cat owner.
     * 
     * PROGRAMMING
     * (2) Create a new DataCollector object and set the data to "socialMediaPostsSmall.txt" and "targetWords.txt"
     *     Important: Use the socialMedialPostsSmall to create your algorithm. Using a small file will help you 
     *     generate your solution quicker and give you the ability to double check your work.
     * (3) Create a String variable to hold the names of all the user. (The first word of every post is 
     *     a person's username)
     * (4) Compare each user's post to each target word. If a user mentions a target word, add their username to 
     *     the String of users. Separate usernames with a space. 
     *         Hint: You can use loops to look through each word. 
     *         Hint2: You can use indexOf to check if a word is in a user post. 
     * (5) Once you have all the users, use your DataCollector's prepareAdvertisement method to prepare a file 
     *     with all users and the advertisement you will send them.
     *         Additional Info: The prepareAdvertisement creates a new file on your computer. Check the posts of
     *         some of the usernames to make sure your algorithm worked.
     * 
     * THE FINAL SOLUTION
     * (6) Your solution should work with the socialMedialPostsSmall.txt. Modify your DataCollector initialization
     *    so you use the socialMediaPosts.txt. You should now have a larger file of users to target.
     */


    DataCollector dc = new DataCollector(); //Step 1 and 2 - we initizlied datacollector and prepped the two files
    dc.setData("socialMediaPosts.txt", "targetWords.txt");
    
    String targetedUsers = ""; // step 3 - variable we used to hold the target user names

    for (int p = 0; p < 39; p++) // step 4 - loop to iterate through posts
    {
      String post = dc.getNextPost();
      boolean match = false; //checks with target word in the inner loop 

      for (int w = 0; w < 20; w++) 
      {
        String target = dc.getNextTargetWord();
        
        if (post.indexOf(target) >= 0)
        {
          match = true;
        }
      }

      if (match)
      {
        String name = post.substring(0, post.indexOf(" ")); //adding a found match + extracting it
        targetedUsers += name + " ";
      }
    }

    dc.prepareAdvertisement("advertisement.txt", targetedUsers, "Baby Shark doo doo doo! Get your Baby Shark toys, clothes, and accessories now! Perfect for the whole family!"); //targted ad written by AI (i couldnt think of anyhting)
  }

}

