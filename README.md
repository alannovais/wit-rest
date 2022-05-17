# README #
    Developed project with Java, Docker and Angular for avaliation a job position.
### Ports used in project ###
    * wit-calculator > 9000;
    * wit-calculator > 9001;
    * angular-wit-example-calculator > 4200;

## Steps for run ##
* System environments:
    * Docker instaled;
    * Node installed;
    * Create a folder which you agroup projects
    * Move docker-compose.yml for outside the path wit-rest;
    * Create a folder with name rabbitmq_data;
## Execute project ##

#### Docker ####
    * Run docker-compose up -d for instace your RabbitMQ;

#### Java ####
* Execute maven install in the projects librabbitmq, wit-calculator and wit-rest ;
* Execute Java applications on projects wit-calculator and wit-rest;
    * Import colletion, wit-challenger.postman_collection.json, for your postman or another request management;
    * You can functions test execute with some endpoints request in collection;

#### Angular ####
* Access wit-angular;
    * run npm install
* You can resquest data for project wit-rest;
    * Access URL http:localhost:4200/
