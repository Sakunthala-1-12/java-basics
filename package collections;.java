package oop;
    import java .util.Arrays;
    public class ExecutionInheritance{

    public static void main(String[]args){

    }
   
}

class Youtube extends Google{
    private String[] likedVideos;
    public Youtube(){
        likedVideos = new String[10];
        likedVideos = new String[] {"MJ Beat It","MJ Dangerous","Iron Man 3"}
    }
    public boolean validate (String pass){
        if (pass.equals(this.getPassword()))return true;
        else return false;
    }
    public void viewLiked(String.userPass){
        if(Validate(userPass)){
            //System.out.println(Arrays.toString(likedVideos));
            System.out.println(:"My liked.videos:");
            for(String.each:likedVideos)
                System.out.println(each);
        }
        else 
            System.out.println("Unauthorized.to.view.liked.videos");
    }
    public String[] getLikedvideos(){
        return likedVideos;
    }
}


//bean class
class Google{
    privateString email,password;
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return passwod;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
