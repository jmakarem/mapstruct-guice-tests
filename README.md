## Unit testing with Mappers

Problem: When developing using a dependency framework (such as Micronaut/ Spring Boot) and the project uses MapStruct with complex mappers,
unit tests can be a bit tricky.

- It makes no sense to load the entire framework, since it will no longer be a unit tests
- It also makes no sense to mock the mappers

So there is a need for a lightweight dependency framework just to load the mappers for the unit tests. This project uses Guice to do that.

### The Example

The Order domain object is composed of other domain objects : Customer, Merchant and Item. The mappers map this Order object to a DTO OrderDetailsDto.

#### MapStruct

The mapper OrderMapper utilizes ItemMapper for mapping items. 

Note : The Mappers are annotated with `@Mapper(componentModel = MappingConstants.ComponentModel.JSR330)` to create beans in the Micronaut framework. The SPRING component model is used for spring. For Guice to work, only the `@Mapper' annotation is needed.

To enable MapStruct add both the dependency and annotation processor as in the pom.xml.

#### Solution 1 : MapStruct Provided
`Mappers.getMapper( OrderMapper.class );`

Advantages : easy to set up/ not added dependencies
Disadvantages : Limited to mappers created by MapStruct


#### Solution 2 : Guice

The AppModule class defines what classes to load in the dependency framework. The interface implementation mapping is explicit.

Advantages : Extendable
Disadvantages : More Dependencies

The OrderMapperTest shows how to use both to get an instance 

 













