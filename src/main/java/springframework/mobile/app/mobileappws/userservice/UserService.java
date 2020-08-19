package springframework.mobile.app.mobileappws.userservice;

import springframework.mobile.app.mobileappws.ui.model.request.UserDetailRequestModel;
import springframework.mobile.app.mobileappws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailRequestModel userDetailRequestModel);
}
