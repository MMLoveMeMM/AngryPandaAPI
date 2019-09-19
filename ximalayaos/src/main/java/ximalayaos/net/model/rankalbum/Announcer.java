/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.rankalbum;

/**
 * Auto-generated: 2019-09-17 14:57:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Announcer {

    private long id;
    private String kind;
    private String nickname;
    private String avatar_url;
    private boolean is_verified;
    private int anchor_grade;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setKind(String kind) {
         this.kind = kind;
     }
     public String getKind() {
         return kind;
     }

    public void setNickname(String nickname) {
         this.nickname = nickname;
     }
     public String getNickname() {
         return nickname;
     }

    public void setAvatar_url(String avatar_url) {
         this.avatar_url = avatar_url;
     }
     public String getAvatar_url() {
         return avatar_url;
     }

    public void setIs_verified(boolean is_verified) {
         this.is_verified = is_verified;
     }
     public boolean getIs_verified() {
         return is_verified;
     }

    public void setAnchor_grade(int anchor_grade) {
         this.anchor_grade = anchor_grade;
     }
     public int getAnchor_grade() {
         return anchor_grade;
     }

}