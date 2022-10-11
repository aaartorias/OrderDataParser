package com.example.parser.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonPropertyOrder({"orderId", "amount", "currency", "comment"})
public class OrderData {
    @JsonProperty("orderId")
    Integer orderId;
    @JsonProperty("amount")
    Double amount;
    @JsonProperty("currency")
    String currency;
    @JsonProperty("comment")
    String comment;
    String fileName;
    Integer line;
    String result;

    @Override
    public String toString() {
        return "orderId: " + getOrderId() + ", amount: " + getAmount() + ", comment: "
                + getComment()
                + ", filename: " + getFileName() + ", line: " + getLine()
                + ", result :" + getResult()
                ;
    }
}
