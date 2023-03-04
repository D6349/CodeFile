$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:FeatureFiles/CurrentAccounts.feature");
formatter.feature({
  "name": "Customer can know the functionality of EQl current Accounts",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Customer can know the different table of their accounts",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Customer can login the EQL site",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.customer_can_login_the_EQL_site()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Customer enter their the creditinals of the page",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.customer_enter_their_the_creditinals_of_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Customer click the login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.customer_click_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Customer can select the their prefered table",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.customer_can_select_the_their_prefered_table()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Customer can know the status of the applications",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.customer_can_know_the_status_of_the_applications()"
});
formatter.result({
  "status": "passed"
});
});