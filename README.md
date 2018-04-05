# Batch Service

The Batch Service mananges CRUD operations for batches. If the current user is a Trainer, that user is able to see their current batches, past/completed batches, and future batches and execute create, read, and update batch SQL statements, but they are not allowed to delete a batch. If the current user is an Admin, that user is able to see all the different batches under each trainer and perform any of the CRUD operations. Services and repositories are used hand in hand to execute the CRUD operations and fallback methods are implemented in case of a service failure.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Java JDK 1.8
Spring Tool Suite (STS)

### Installing

Either:
- Download the ZIP for the repo and unzip it
- Clone the repo
Import the existing Maven project in STS
Run it as a Spring Boot App

## Running the tests

There are none :)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Josh Boudreau** - *Code cleanup* - [jboud17](https://github.com/jboud17)
* **Sonam Sherpa** - *Code cleanup* - [stsherpa](https://github.com/stsherpa)
* **Marko Miocic** - *Code cleanup* - [mmiocic](https://github.com/mmiocic)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Inspiration - Revature told us to
