/*
 * Copyright 2006-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.batch.core.repository.dao;

import java.util.Collection;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;

public interface StepExecutionDao {

	/**
	 * Save the given StepExecution.
	 * 
	 * Preconditions: Id must be null.
	 * 
	 * Postconditions: Id will be set to a unique Long.
	 * 
	 * @param stepExecution
	 */
	void saveStepExecution(StepExecution stepExecution);

	/**
	 * Save the given collection of StepExecution as a batch.
	 * 
	 * Preconditions: StepExecution Id must be null.
	 * 
	 * Postconditions: StepExecution Id will be set to a unique Long.
	 * 
	 * @param stepExecutions
	 */
	void saveStepExecutions(Collection<StepExecution> stepExecutions);

	/**
	 * Update the given StepExecution
	 * 
	 * Preconditions: Id must not be null.
	 * 
	 * @param stepExecution
	 */
	void updateStepExecution(StepExecution stepExecution);

	/**
	 * Retrieve a {@link StepExecution} from its id.
	 * 
	 * @param jobExecution the parent {@link JobExecution}
	 * @param stepExecutionId the step execution id
	 * @return a {@link StepExecution}
	 */
	StepExecution getStepExecution(JobExecution jobExecution, Long stepExecutionId);

	/**
	 * Retrieve all the {@link StepExecution} for the parent {@link JobExecution}.
	 * 
	 * @param jobExecution the parent job execution
	 */
	void addStepExecutions(JobExecution jobExecution);

	/**
	 * Counts all the {@link StepExecution} for a given step name.
	 *
	 * @param jobInstance the parent {@link JobInstance}
	 * @param stepName the name of the step
	 * @since 4.2.2
	 * @return the count of {@link StepExecution}s for a given step
	 */
	int countStepExecutions(JobInstance jobInstance, String stepName);
}
