# Spring boot starter for using Tarantool database and Spring Data Tarantool for Spring Framework's caching support

This project provides Spring Boot starter that allow you to work with Spring Framework's cache based on Tarantool
database in your Spring Boot applications.

## How to use in your project

To add the starter to a Maven-based project, add the following dependency:

```maven
<dependencies>
	<dependency>
		<groupId>io.github.selevinia</groupId>
		<artifactId>selevinia-spring-boot-starter-cache-tarantool</artifactId>
		<version>${version}</version>
	</dependency>
</dependencies>
```

For Gradle, use the following declaration:

```gradle
dependencies {
    implementation "io.github.selevinia:selevinia-spring-boot-starter-cache-tarantool:$version"
}
```

## Properties

It's possible to override the default properties listed here below.

| Parameter | Default value | Description |
| --- | --- | --- |
| selevinia.cache.tarantool.enabled                                 | false | Enable Tarantool cache |
| selevinia.cache.tarantool.cache-names                             |  | Comma-separated list of cache names to create if supported by the underlying cache manager. Usually, this disables the ability to create additional caches on-the-fly |
| selevinia.cache.tarantool.cache-name-prefix                       |  | Cache name prefix |
| selevinia.cache.tarantool.cache-null-values                       |  | Allow caching null values |
| selevinia.cache.tarantool.time-to-live                            |  | Entry expiration. By default, the entries never expire. If a duration suffix is not specified, milliseconds will be used |
| selevinia.cache.tarantool.enable-statistics                       | false | Enable cache statistics |
| spring.data.tarantool.nodes                                       | localhost:3301 | Comma-separated list of Tarantool nodes (host:port) to connect to |
| spring.data.tarantool.user-name                                   | guest | Tarantool user name |
| spring.data.tarantool.password                                    |  | Tarantool user password |
| spring.data.tarantool.connections                                 | 1 | Number of connections used for sending requests to the server |
| spring.data.tarantool.connect-timeout                             | 1000ms | Timeout for connecting to the Tarantool server. If a duration suffix is not specified, milliseconds will be used |
| spring.data.tarantool.read-timeout                                | 1000ms | Timeout for reading the responses from Tarantool server. If a duration suffix is not specified, milliseconds will be used |
| spring.data.tarantool.request-timeout                             | 2000ms | Timeout for receiving a response from the Tarantool server. If a duration suffix is not specified, milliseconds will be used |
| spring.data.tarantool.field-naming-strategy                       | org.springframework.data.mapping.model.PropertyNameFieldNamingStrategy | Fully qualified name of the FieldNamingStrategy to use |
| spring.data.tarantool.cluster                                     | true | Enable tarantool cluster mode |
| spring.data.tarantool.crud                                        | true | Enable Tarantool CRUD module usage |
| spring.data.tarantool.proxy-operations.get-schema-function-name   | ddl.get_schema | API function name for getting the spaces and indexes schema |
| spring.data.tarantool.proxy-operations.delete-function-name       | crud.delete | API function name for performing the delete operation |
| spring.data.tarantool.proxy-operations.insert-function-name       | crud.insert | API function name for performing the insert operation |
| spring.data.tarantool.proxy-operations.replace-function-name      | crud.replace | API function name for performing the replace operation |
| spring.data.tarantool.proxy-operations.update-function-name       | crud.update | API function name for performing the update operation |
| spring.data.tarantool.proxy-operations.upsert-function-name       | crud.upsert | API function name for performing the upsert operation |
| spring.data.tarantool.proxy-operations.select-function-name       | crud.select | API function name for performing the select operation |

## Learn more

- [Spring Data Tarantool](https://github.com/selevinia/spring-data-tarantool)

## License

This project is Open Source software released under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)