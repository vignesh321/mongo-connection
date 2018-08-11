package org.mongo.model;

public class UserRepositoryImpl implements UserRepositoryCustom {

    private static String collectionName = "Person";

    @Override
    public String getCollectionName() {
        return collectionName;
    }

    @Override
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}