package com.certification.bunasolappBackEnd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.certification.bunasolappBackEnd.entity.Agent;
import com.certification.bunasolappBackEnd.service.AgentService;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

	@Autowired
	private AgentService agentService;

	@GetMapping
	public ResponseEntity<List<Agent>> getListAgents() {
		List<Agent> agents = agentService.getListAgents();
		return new ResponseEntity<>(agents, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Agent> getAgentById(@PathVariable Long id) {
		Optional<Agent> agent = agentService.getAgentById(id);
		return agent.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
		Agent savedAgent = agentService.createAgent(agent);
		return new ResponseEntity<>(savedAgent, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Agent> updateAgent(@PathVariable Long id, @RequestBody Agent updatedAgent) {
		Agent agent = agentService.updateAgent(id, updatedAgent);
		return new ResponseEntity<>(agent, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
		agentService.deleteAgent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// Endpoint pour mettre à jour le mot de passe d'un agent
	@PutMapping("/{id}/updatePassword")
	public ResponseEntity<Agent> updatePasswordAgent(@PathVariable Long id, @RequestParam String password) {
		Agent updatedAgent = agentService.updatePasswordAgent(id, password);
		if (updatedAgent != null) {
			return new ResponseEntity<>(updatedAgent, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}/updatedRole")
	public ResponseEntity<Agent> updateRoleAgent(@PathVariable Long id, @RequestParam String role) {
		// Endpoint pour mettre à jour le role d'un agent

		Agent updatedAgent = agentService.updateRoleAgent(id, role);
		if (updatedAgent != null) {
			return new ResponseEntity<>(updatedAgent, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
