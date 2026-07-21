import styles from './CohortDetails.module.css';

function CohortDetails() {
  const cohorts = [
    {
      id: 1,
      name: 'Java Full Stack - Batch 2024',
      startDate: '01-Jan-2024',
      endDate: '30-Jun-2024',
      status: 'completed',
      students: 45
    },
    {
      id: 2,
      name: 'React Deep Skilling - Batch 2025',
      startDate: '15-Jul-2024',
      endDate: '15-Sep-2024',
      status: 'ongoing',
      students: 38
    },
    {
      id: 3,
      name: 'Python & Data Science - Batch 2025',
      startDate: '01-Aug-2024',
      endDate: '31-Oct-2024',
      status: 'ongoing',
      students: 42
    },
    {
      id: 4,
      name: 'Angular Advanced - Batch 2023',
      startDate: '01-Dec-2023',
      endDate: '29-Feb-2024',
      status: 'completed',
      students: 35
    }
  ];

  return (
    <div className={styles.container}>
      <div className={styles.header}>
        <h1>Cohort Management Dashboard</h1>
        <p>View ongoing and completed cohorts</p>
      </div>

      {cohorts.map(cohort => (
        <div key={cohort.id} className={styles.box}>
          <h3>{cohort.name}</h3>
          <p><strong>Start Date:</strong> {cohort.startDate}</p>
          <p><strong>End Date:</strong> {cohort.endDate}</p>
          <p><strong>Status:</strong> 
            <span className={`${styles.status} ${styles[cohort.status]}`}>
              {cohort.status.toUpperCase()}
            </span>
          </p>
          <p><strong>Students Enrolled:</strong> {cohort.students}</p>
        </div>
      ))}
    </div>
  );
}

export default CohortDetails;