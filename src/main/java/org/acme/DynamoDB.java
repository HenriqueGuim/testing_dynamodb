package org.acme;

import io.quarkus.runtime.Startup;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class DynamoDB {

    private final DynamoDbClient dynamoDbClient;

    @Inject
    public DynamoDB(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;

    }

    @Startup
    public void createTable() {
        List<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("PK")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("SK")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Name")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Status")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Item")
                .attributeType("L")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Priority")
                .attributeType("N")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Date")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Assigned")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Serial_Number")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Brand")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Model")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Supplier")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Notes")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Warranty")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Invoice")
                .attributeType("B")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Location")
                .attributeType("M")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Available_model")
                .attributeType("L")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Profile")
                .attributeType("S")
                .build());
        attributeDefinitions.add(AttributeDefinition.builder()
                .attributeName("Entity_type")
                .attributeType("S")
                .build());

        List<KeySchemaElement> KeySchema = new ArrayList<KeySchemaElement>();
        KeySchema.add(KeySchemaElement.builder()
                .attributeName("PK")
                .keyType("HASH")
                .build());
        KeySchema.add(KeySchemaElement.builder()
                .attributeName("SK")
                .keyType("RANGE")
                .build());


        List<GlobalSecondaryIndex> globalSecondaryIndexes = new ArrayList<GlobalSecondaryIndex>();
        globalSecondaryIndexes.add(GlobalSecondaryIndex.builder()
                .indexName("Entity_Type_by_Status")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Entity_type")
                        .keyType("HASH")
                        .build(),
                        KeySchemaElement.builder()
                                .attributeName("Status")
                                .keyType("RANGE")
                                .build())
                .projection(Projection.builder()
                        .projectionType("All")
                        .build())
                .build());

        globalSecondaryIndexes.add(GlobalSecondaryIndex.builder()
                .indexName("Entity_Type_by_Date")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Entity_type")
                        .keyType("HASH")
                        .build(),
                        KeySchemaElement.builder()
                                .attributeName("Date")
                                .keyType("RANGE")
                                .build())
                .projection(Projection.builder()
                        .projectionType("All")
                        .build())
                .build());

        globalSecondaryIndexes.add(GlobalSecondaryIndex.builder()
                .indexName("Entity_Type")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Entity_type")
                        .keyType("HASH")
                .build()).build());

        globalSecondaryIndexes.add(GlobalSecondaryIndex.builder()
                .indexName("Tag_by_PK")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Tag")
                        .keyType("HASH")
                        .build(),
                        KeySchemaElement.builder()
                                .attributeName("PK")
                                .keyType("RANGE")
                                .build())
                .projection(Projection.builder()
                        .projectionType("All")
                        .build())
                .build());

        globalSecondaryIndexes.add(GlobalSecondaryIndex.builder()
                .indexName("Model_by_PK")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Model")
                        .keyType("HASH")
                        .build(),
                        KeySchemaElement.builder()
                                .attributeName("PK")
                                .keyType("RANGE")
                                .build())
                .projection(Projection.builder()
                        .projectionType("All")
                        .build())
                .build());

        globalSecondaryIndexes.add(GlobalSecondaryIndex.builder()
                .indexName("Entity_Type_by_Assigned")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Entity_type")
                        .keyType("HASH")
                        .build(),
                        KeySchemaElement.builder()
                                .attributeName("Assigned")
                                .keyType("RANGE")
                                .build())
                .projection(Projection.builder()
                        .projectionType("All")
                        .build())
                .build());

        globalSecondaryIndexes.add(GlobalSecondaryIndex.builder()
                .indexName("Entity_Type_by_Priority")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Entity_type")
                        .keyType("HASH")
                        .build(),
                        KeySchemaElement.builder()
                                .attributeName("Priority")
                                .keyType("RANGE")
                                .build())
                .projection(Projection.builder()
                        .projectionType("All")
                        .build())
                .build());

        globalSecondaryIndexes.add(GlobalSecondaryIndex.builder()
                .indexName("Entity_Type_by_Brand")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Entity_type")
                        .keyType("HASH")
                        .build(),
                        KeySchemaElement.builder()
                                .attributeName("Brand")
                                .keyType("RANGE")
                                .build())
                .projection(Projection.builder()
                        .projectionType("All")
                        .build())
                .build());

        globalSecondaryIndexes.add(GlobalSecondaryIndex.builder()
                .indexName("Entity_Type_by_Warranty")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Entity_type")
                        .keyType("HASH")
                        .build(),
                        KeySchemaElement.builder()
                                .attributeName("Warranty")
                                .keyType("RANGE")
                                .build())
                .projection(Projection.builder()
                        .projectionType("All")
                        .build())
                .build());



        CreateTableRequest request = CreateTableRequest.builder()
                .tableName("Minka")
                .attributeDefinitions(attributeDefinitions)
                .keySchema(KeySchema)
                .globalSecondaryIndexes(globalSecondaryIndexes)
                .billingMode(BillingMode.PAY_PER_REQUEST)
                .build();

        CreateTableResponse createTableResponse = dynamoDbClient.createTable(request);


        System.out.println(createTableResponse.tableDescription());

    }


}
