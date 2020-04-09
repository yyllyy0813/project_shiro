package com.z_y.project_shiro.service;

import com.z_y.project_shiro.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Integer>
{
}
