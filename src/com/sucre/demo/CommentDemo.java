package com.sucre.demo;

import java.util.Date;

public class CommentDemo {

    class NewComment{
        public Date time;
        public String content;
        public Object user;

        public ParentInfo info;

        public NewComment(Comment comment) {
            this.time = comment.time;
            //....
        }
        public NewComment(ToComment toComment){
            //....
        }

    }
    class ParentInfo{
        public String content;
        public Dynamic dynamic;
    }



    class Dynamic{

    }
    class Comment{
        public Date time;
        public String content;
        public Object user;

        public Dynamic dynamic;
    }
    class ToComment{
        public Date time;
        public String content;
        public Object user;

        public Comment comment;
    }
}
