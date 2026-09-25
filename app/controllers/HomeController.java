package controllers;

import actions.JwtAction; // Import Middleware vừa tạo
import play.mvc.*;

public class HomeController extends Controller {


    @With(JwtAction.class)
    public Result index() {
        return ok("Hello World - Xác thực Token thành công!");
    }
}