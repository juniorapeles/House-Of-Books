import os
import re
import sys

def get_base_package_from_main_class():
    java_src_path = os.path.join("src", "main", "java")
    for root, _, files in os.walk(java_src_path):
        for file in files:
            if file.endswith(".java"):
                path = os.path.join(root, file)
                with open(path, "r", encoding="utf-8") as f:
                    content = f.read()
                    if "public static void main" in content:
                        match = re.search(r"package\s+([a-zA-Z0-9_.]+);", content)
                        if match:
                            return match.group(1)
    print("Classe com método main não encontrada.")
    sys.exit(1)

def get_generics_package(base_package):
    return base_package.split(".features")[0] + ".generics"

def create_dirs(base_path, feature):
    for folder in ["controller", "dto", "mapper", "service", "domain", "repository"]:
        path = os.path.join(base_path, feature, folder)
        os.makedirs(path, exist_ok=True)
        print(f"Diretório criado: {path}")

def to_camel_case(s):
    return ''.join(word.capitalize() for word in s.split('_'))

def create_dto(base_package, feature, feature_camel, base_path):
    content = f"""package {base_package}.{feature}.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class {feature_camel}DTO {{

    // TODO: Defina os campos do DTO aqui

}}"""
    path = os.path.join(base_path, feature, "dto", f"{feature_camel}DTO.java")
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"DTO criado: {path}")

def create_mapper(base_package, feature, feature_camel, base_path):
    content = f"""package {base_package}.{feature}.mapper;

import {base_package}.{feature}.dto.{feature_camel}DTO;
import {base_package}.{feature}.domain.{feature_camel};
import {get_generics_package(base_package)}.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface {feature_camel}Mapper extends GenericMapper<{feature_camel}, {feature_camel}DTO> {{

}}"""
    path = os.path.join(base_path, feature, "mapper", f"{feature_camel}Mapper.java")
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"Mapper criado: {path}")

def create_service(base_package, feature, feature_camel, base_path):
    content = f"""package {base_package}.{feature}.service;

import {base_package}.{feature}.dto.{feature_camel}DTO;
import {base_package}.{feature}.domain.{feature_camel};
import {base_package}.{feature}.mapper.{feature_camel}Mapper;
import {get_generics_package(base_package)}.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class {feature_camel}Service extends GenericServiceImpl<{feature_camel}, {feature_camel}DTO, Long, {feature_camel}Mapper> {{

    public {feature_camel}Service(JpaRepository<{feature_camel}, Long> repository, {feature_camel}Mapper mapper) {{
        super(repository, mapper);
    }}

}}"""
    path = os.path.join(base_path, feature, "service", f"{feature_camel}Service.java")
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"Service criado: {path}")

def create_controller(base_package, feature, feature_camel, feature_lower, base_path):
    content = f"""package {base_package}.{feature}.controller;

import {get_generics_package(base_package)}.GenericController;
import {base_package}.{feature}.dto.{feature_camel}DTO;
import {get_generics_package(base_package)}.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("{feature_lower}s")
public class {feature_camel}Controller extends GenericController<{feature_camel}DTO, Long> {{

    public {feature_camel}Controller(GenericService<{feature_camel}DTO, Long> service) {{
        super(service);
    }}

}}"""
    path = os.path.join(base_path, feature, "controller", f"{feature_camel}Controller.java")
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"Controller criado: {path}")

def create_domain(base_package, feature, feature_camel, base_path):
    content = f"""package {base_package}.{feature}.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_{feature.lower()}")
public class {feature_camel} {{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Defina de {feature_camel} aqui.

}}"""
    path = os.path.join(base_path, feature, "domain", f"{feature_camel}.java")
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"Model (domain) criado: {path}")

def create_repository(base_package, feature, feature_camel, base_path):
    content = f"""package {base_package}.{feature}.repository;

import {base_package}.{feature}.domain.{feature_camel};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface {feature_camel}Repository extends JpaRepository<{feature_camel}, Long> {{

}}"""
    path = os.path.join(base_path, feature, "repository", f"{feature_camel}Repository.java")
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"Repository criado: {path}")

def gerar_feature(feature, base_package, java_base_path):
    feature = feature.strip().lower()
    feature_camel = to_camel_case(feature)

    create_dirs(java_base_path, feature)
    create_dto(base_package, feature, feature_camel, java_base_path)
    create_domain(base_package, feature, feature_camel, java_base_path)
    create_repository(base_package, feature, feature_camel, java_base_path)
    create_mapper(base_package, feature, feature_camel, java_base_path)
    create_service(base_package, feature, feature_camel, java_base_path)
    create_controller(base_package, feature, feature_camel, feature, java_base_path)

def main():
    if len(sys.argv) != 2:
        print("Use: python gerar_feature.py <feature1,feature2,...>")
        sys.exit(1)

    features = sys.argv[1].split(",")
    base_package = get_base_package_from_main_class()
    print(f"Package base detectado: {base_package}")

    features_package = f"{base_package}.features"
    java_base_path = os.path.join("src", "main", "java", *features_package.split('.'))
    os.makedirs(java_base_path, exist_ok=True)

    for feature in features:
        gerar_feature(feature, features_package, java_base_path)

if __name__ == "__main__":
    main()
