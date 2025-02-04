package com.trainibit.test_validations.mapper.impl;

import org.springframework.stereotype.Service;

import com.trainibit.test_validations.entity.UserData;
import com.trainibit.test_validations.mapper.UserDataMapper;
import com.trainibit.test_validations.request.UserDataRequestKafka;

@Service
public class UserDataMapperImpl implements UserDataMapper{
    @Override
    public UserData requestToEntity(UserDataRequestKafka userDataRequestKafka) {
        UserData userData = new UserData();

        userData.setEmail(userDataRequestKafka.getEmail());
        userData.setFirstToken(userDataRequestKafka.getFirstToken());
        userData.setTemplateUuid(userDataRequestKafka.getTemplateUuid());
        userData.setUuid(userDataRequestKafka.getUuid());

        return userData;
    }
}
