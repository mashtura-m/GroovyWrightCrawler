package com.mashtura.crawler.entity;

import java.util.List;
import java.util.Map;

public class EntityRecords implements EntityData {

    private String entityId;
    private String entityType;
    private List<String> address;
    private List<String> associatedEntities;
    private List<String> sourceUrls;
    private List<String> events;
    private String entityName;

    @Override
    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    @Override
    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @Override
    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    @Override
    public List<String> getAssociatedEntities() {
        return associatedEntities;
    }

    public void setAssociatedEntities(List<String> associatedEntities) {
        this.associatedEntities = associatedEntities;
    }

    @Override
    public List<String> getSource() {
        return sourceUrls;
    }

    public void setSourceUrls(List<String> sourceUrls) {
        this.sourceUrls = sourceUrls;
    }


    @Override
    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    @Override
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public String findById(String entityId) {
        return null; // Placeholder for actual implementation
    }

    @Override
    public EntityRecords updateEntity(String entityId, Map newData, EntityRecords entity) {
        return null; // Placeholder for actual implementation
    }
}