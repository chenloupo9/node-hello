terraform {
  backend "s3" {
    bucket ="compie-terraform-state"
    key ="terraform/demo4"
  }
}