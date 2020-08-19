package springframework.mobile.app.mobileappws.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springframework.mobile.app.mobileappws.shared.Utils;
import springframework.mobile.app.mobileappws.ui.model.request.UserDetailRequestModel;
import springframework.mobile.app.mobileappws.ui.model.response.UserRest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;
    public UserServiceImpl() {
    }


    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailRequestModel userDetailRequestModel) {

        UserRest userRest = new UserRest();
        userRest.setEmail(userDetailRequestModel.getEmail());
        userRest.setFirstName(userDetailRequestModel.getFirstName());
        userRest.setLastName(userDetailRequestModel.getLastName());
        String userId = utils.generateUserId();
        userRest.setUserId(userId);
        if(users==null){
            users = new HashMap<>();
        }
        users.put(userId,userRest);
        return userRest;
    }
}
