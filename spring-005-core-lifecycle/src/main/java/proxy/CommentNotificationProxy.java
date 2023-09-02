package proxy;

import com.cydeo.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
