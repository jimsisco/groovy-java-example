Feature: Center Search

  Scenario: Search for a center based on Zip Code
    Given I navigate to Kindercare Home page on URL "http://kindercare.com"
      When Title is "KinderCare | Child Daycare Centers & Early Education Programs"
        Then I click  Find My Center
        Then It should have taken me to Center Search Results | KinderCare
        Then I enter my zip code "97236"
        Then I click Search Again
        Then I can see the center and click Tuition and Openings
        Then I can see "Center Search Results | KinderCare"
