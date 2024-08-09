Feature: Tests for Demoblaze Authentication

Scenario: Crear un nuevo usuario al registrarse
    Given url 'https://api.demoblaze.com/signup'
    And request { "username": "user098761", "password": "password123" }
    When method post
    Then status 200
    And match response.errorMessage == 'null'

Scenario: Intentar crear un usuario ya existente
    Given url 'https://api.demoblaze.com/signup'
    And request { "username": "user098761", "password": "password123" }
    When method post
    Then status 409
    And match response.errorMessage == 'This user already exist.'

Scenario: Usuario y contraseña correcta al iniciar sesión
    Given url 'https://api.demoblaze.com/login'
    And request { "username": "user098761", "password": "password123" }
    When method post
    Then status 200
    And match response.errorMessage == 'Login successful.'

Scenario: Usuario y contraseña incorrecta al iniciar sesión
    Given url 'https://api.demoblaze.com/login'
    And request { "username": "user098761", "password": "wrongpassword" }
    When method post
    Then status 401
    And match response.errorMessage == 'Wrong password.'



