import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails() {
  const cohorts = [
    { id: 1, code: 'ADM26DF001', name: 'Java Full Stack React', status: 'ongoing', startDate: '01/06/2026', strength: 25 },
    { id: 2, code: 'ADM26DF002', name: 'DotNet Full Stack Angular', status: 'completed', startDate: '15/02/2026', strength: 20 },
    { id: 3, code: 'ADM26DF003', name: 'Cloud Native DevOps', status: 'ongoing', startDate: '15/06/2026', strength: 30 }
  ];

  return (
    <div style={{ textAlign: 'center', padding: '20px' }}>
      <h2 style={{ color: '#2c3e50', marginBottom: '20px' }}>Cohort Details Dashboard</h2>
      <div>
        {cohorts.map(cohort => (
          <div key={cohort.id} className={styles.box}>
            <h3 style={{ color: cohort.status === 'ongoing' ? 'green' : 'blue', textTransform: 'capitalize' }}>
              {cohort.name} ({cohort.status})
            </h3>
            <dl>
              <dt>Cohort Code</dt>
              <dd>{cohort.code}</dd>
              <dt>Start Date</dt>
              <dd>{cohort.startDate}</dd>
              <dt>Strength</dt>
              <dd>{cohort.strength} Learners</dd>
            </dl>
          </div>
        ))}
      </div>
    </div>
  );
}

export default CohortDetails;
