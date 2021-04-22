package com.ge.hc.mdi.calculatorservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "RESULT")
public class Result {

  @Id
  @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy = "uuid")
  @Column(name = "ID")
  private String id;

  @Column(name = "INPUT_1")
  private int input1;

  @Column(name = "INPUT_2")
  private int input2;

  @Column(name = "RESULT")
  private int result;

  public Result(int input1, int input2, int result) {
    this.input1 = input1;
    this.input2 = input2;
    this.result = result;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getInput1() {
    return input1;
  }

  public void setInput1(int input1) {
    this.input1 = input1;
  }

  public int getInput2() {
    return input2;
  }

  public void setInput2(int input2) {
    this.input2 = input2;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
