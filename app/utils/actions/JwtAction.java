package actions;

import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import utils.JwtUtil;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class JwtAction extends Action.Simple {

    @Override
    public CompletionStage<Result> call(Http.Request req) {
        // Lấy header Authorization
        Optional<String> authHeader = req.header("Authorization");

        if (!authHeader.isPresent() || !authHeader.get().startsWith("Bearer ")) {
            return CompletableFuture.completedFuture(
                unauthorized("Error: Thiếu Token hoặc định dạng Header không hợp lệ!")
            );
        }

        String token = authHeader.get().substring(7); // Cắt bỏ chuỗi "Bearer "

        try {
            JwtUtil.verifyToken(token);
            return delegate.call(req); // Token hợp lệ, cho phép request đi tiếp
        } catch (Exception e) {
            return CompletableFuture.completedFuture(
                unauthorized("Error: Token không hợp lệ hoặc đã hết hạn!")
            );
        }
    }
}