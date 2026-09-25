package controllers;

import actions.JwtAction;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;
import utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;

public class AuthController extends Controller {

    // 1. API Đăng nhập & Sinh JWT
    public Result login(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest("Dữ liệu gửi lên phải là định dạng JSON!");
        }

        String userName = json.has("userName") ? json.get("userName").asText() : "";
        String password = json.has("password") ? json.get("password").asText() : "";

        // Giả lập kiểm tra tài khoản (Khớp với cấu trúc Bảng User)
        if ("admin".equals(userName) && "123456".equals(password)) {
            String token = JwtUtil.generateToken(userName);

            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("token", token);

            return ok(Json.toJson(response));
        }

        return unauthorized("Tài khoản hoặc mật khẩu không chính xác!");
    }

    // 2. API /auth - Yêu cầu xác thực qua Middleware (JwtAction)
    @With(JwtAction.class)
    public Result auth() {
        return ok("Hello World - Xác thực Token thành công!");
    }
}