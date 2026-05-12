# Use Maven image with Java 11
FROM maven:3.9.6-eclipse-temurin-11

# Set working directory
WORKDIR /app

# Install Chrome for Selenium tests
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" \
    >> /etc/apt/sources.list.d/google.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Copy pom.xml first for better layer caching
COPY pom.xml .

# Download dependencies (cached layer)
RUN mvn dependency:go-offline -q

# Copy project files
COPY . .

# Run smoke tests by default
CMD ["mvn", "test", "-Dcucumber.filter.tags=@smoke"]
