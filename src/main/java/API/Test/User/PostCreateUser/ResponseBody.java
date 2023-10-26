package API.Test.User.PostCreateUser;

class ResponseBody {
    private int code;
    private String type;
    private String message;

    public ResponseBody(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public ResponseBody() {
    }

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
