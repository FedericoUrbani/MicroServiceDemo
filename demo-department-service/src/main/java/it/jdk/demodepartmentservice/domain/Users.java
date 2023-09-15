package it.jdk.demodepartmentservice.domain;


public record Users(Long id, Long departmentId, String name, int age, String position) {
}
