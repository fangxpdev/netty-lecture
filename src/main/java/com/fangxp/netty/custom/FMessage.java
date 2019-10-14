package com.fangxp.netty.custom;

public class FMessage {

    private String content;

    private FMessageHeader messageHeader;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FMessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(FMessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    @Override
    public String toString() {
        return "FMessage{" +
                "content='" + content + '\'' +
                ", messageHeader=" + messageHeader +
                '}';
    }
}
