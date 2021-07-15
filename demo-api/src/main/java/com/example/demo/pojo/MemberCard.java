package com.example.demo.pojo;

import java.io.Serializable;

public class MemberCard implements Serializable {
    private String member_id;
    private String card_id;

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    @Override
    public String toString() {
        return "MemberCard{" +
                "member_id=" + member_id +
                ", card_id='" + card+id +
                '}';
    }
}
