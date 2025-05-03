# Open Info Hub

   <img src="https://github.com/dobval/open-info-hub/blob/main/media/open-info-hub.gif?raw=true" alt="open-info-hub" style="width: 400px; height: auto;" />

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [License](#license)

## Introduction

Open Info Hub is full-stack Java web app that aggregates real-time data from various APIs - GitHub, [Open-Meteo](https://api.open-meteo.com/v1/forecast), [Openstreetmap](https://nominatim.openstreetmap.org/search) (geocoding cities) and [currency exchange services](https://open.er-api.com/v6/latest/EUR) - into a responsive UI.

## Features

- **GitHub User Info**: Display followers and public repositories.
- **Weather Forecast**: Clean, 7-day max temperature chart for any city using Chart.js
- **Currency Exchange**: Latest EUR to USD exchange rate from an external API

## Technologies Used

| Layer        | Tools / Libraries                 |
| ------------ | --------------------------------- |
| **Backend**  | Java 17+, Spring Boot, Spring MVC |
| **Frontend** | Thymeleaf, Bootstrap 5, Chart.js  |
| **Testing**  | JUnit, Mockito                    |
| **Build**    | Maven                             |
| **APIs**     | GitHub API, Open-Meteo, ER API    |

## Setup

### Prerequisites

- Java 17 or higher (not tested on older versions)
- Maven

### Installation

	git clone https://github.com/dobval/open-info-hub.git
	cd open-info-hub
	mvn clean install
	mvn spring-boot:run

## Usage

1. Open your browser and navigate to `http://localhost:8080`.
2. Enter a GitHub username and a city name to see the aggregated information.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
