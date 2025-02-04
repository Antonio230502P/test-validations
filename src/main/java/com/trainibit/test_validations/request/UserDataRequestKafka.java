package com.trainibit.test_validations.request;

import java.util.UUID;

import lombok.Data;

@Data
public class UserDataRequestKafka {
    private String firstToken;
    private UUID templateUuid;
    private UUID uuid;
    private String email;
}
