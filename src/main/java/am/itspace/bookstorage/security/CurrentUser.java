package am.itspace.companycmployeespring.security;
import am.itspace.companycmployeespring.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

//Սեքուրիտին ապահովելու համար
public class CurrentUser  extends org.springframework.security.core.userdetails.User {
    private User user;
    //current user միջանկյալ յուզեր է որը սպրինգը կկապե մեր յուզերի հետ
    public CurrentUser  (User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().name()));
        this.user=user;
    }
    public User getUser(){
        return user;
    }
}
