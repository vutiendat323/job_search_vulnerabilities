package com.example.jobsearch;

import com.example.jobsearch.model.Job;
import com.example.jobsearch.model.User;
import com.example.jobsearch.repository.JobRepository;
import com.example.jobsearch.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final JobRepository  jobRepository;

    public DataInitializer(UserRepository userRepository, JobRepository jobRepository) {
        this.userRepository = userRepository;
        this.jobRepository  = jobRepository;
    }

    @Override
    public void run(String... args) {
        seedUsers();
        seedJobs();
    }

    private void seedUsers() {
        if (userRepository.count() > 0) return;

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin123");
        admin.setRole("ADMIN");
        userRepository.save(admin);

        User alice = new User();
        alice.setUsername("alice");
        alice.setPassword("password123");
        alice.setRole("USER");
        userRepository.save(alice);

        User bob = new User();
        bob.setUsername("bob");
        bob.setPassword("iloveyou");
        bob.setRole("USER");
        userRepository.save(bob);

        User charlie = new User();
        charlie.setUsername("charlie");
        charlie.setPassword("hunter2");
        charlie.setRole("USER");
        userRepository.save(charlie);
    }

    private void seedJobs() {
        if (jobRepository.count() > 0) return;

        String[][] jobs = {
            {
                "Senior Frontend Developer",
                "FPT Software",
                "We are looking for a Senior Frontend Developer to join our growing product team. You will work closely with designers and backend engineers to build fast, beautiful web applications used by millions of users.\n\nRequirements:\n- 3+ years experience with React or Vue.js\n- Proficient in TypeScript, HTML5, CSS3\n- Experience with REST APIs and state management (Redux/Zustand)\n- Strong understanding of responsive design and web performance\n- Familiarity with CI/CD, Git workflows\n\nBenefits:\n- Salary: $1,500 – $2,500/month\n- 13th-month bonus + performance bonus\n- Hybrid remote (3 days office, 2 days WFH)\n- Health insurance + annual health check\n- Annual team trip"
            },
            {
                "Java Backend Engineer",
                "VNG Corporation",
                "VNG Corporation is hiring a Java Backend Engineer to help scale our platform serving over 10 million daily active users. You will design and build reliable, high-performance microservices.\n\nRequirements:\n- 3+ years experience with Java (Spring Boot, Spring MVC)\n- Solid knowledge of MySQL, PostgreSQL, Redis\n- Experience with microservices and RESTful API design\n- Familiarity with Kafka or RabbitMQ\n- Understanding of distributed system concepts\n\nBenefits:\n- Salary: $1,800 – $3,000/month\n- Zalo Plus subscription\n- Annual tech conference budget\n- Stock option program\n- Canteen on-site"
            },
            {
                "DevOps / Cloud Engineer",
                "Tiki",
                "Join Tiki's infrastructure team to design, build, and maintain the cloud platform powering Vietnam's leading e-commerce site. You will ensure our systems are reliable, scalable, and secure.\n\nRequirements:\n- 2+ years experience with Docker and Kubernetes\n- Hands-on knowledge of AWS or GCP\n- Experience with Terraform or Ansible for infrastructure as code\n- Familiarity with Prometheus, Grafana, ELK stack\n- Scripting skills in Bash and/or Python\n\nBenefits:\n- Salary: $1,500 – $2,800/month\n- Monthly Tiki shopping vouchers\n- Flexible working hours\n- Annual company trip\n- Learning & development budget"
            },
            {
                "Product Manager",
                "MoMo E-Wallet",
                "MoMo is looking for an experienced Product Manager to drive the development of new payment and fintech features. You will own the product roadmap and collaborate with engineering, design, and business teams.\n\nRequirements:\n- 3+ years experience as a Product Manager at a tech company\n- Strong analytical skills, experience with data-driven decision making\n- Excellent communication and cross-functional leadership skills\n- Experience writing PRDs and user stories\n- Familiarity with Agile / Scrum methodology\n\nBenefits:\n- Salary: $2,000 – $3,500/month\n- MoMo premium wallet benefits\n- $500/year Learning & Development budget\n- International business trips\n- Fast career growth"
            },
            {
                "UI/UX Designer",
                "VinAI Research",
                "VinAI Research is hiring a talented UI/UX Designer to create intuitive, beautiful interfaces for our suite of AI-powered products. You will be involved in every step of the design process, from research to delivery.\n\nRequirements:\n- 2+ years of UI/UX design experience\n- Proficient in Figma and Adobe Creative Suite\n- Strong portfolio demonstrating a user-centered design process\n- Experience conducting user research and usability testing\n- Understanding of design systems and accessibility standards\n\nBenefits:\n- Salary: $1,200 – $2,000/month\n- Work directly with AI research scientists\n- Annual design conference budget\n- Creative, collaborative culture\n- MacBook Pro provided"
            },
            {
                "Data Analyst",
                "Grab Vietnam",
                "Grab Vietnam is looking for a Data Analyst to help uncover insights from our massive dataset spanning ride-hailing, food delivery, and financial services. Your analysis will directly influence product and business decisions.\n\nRequirements:\n- 2+ years of hands-on data analysis experience\n- Strong SQL skills (PostgreSQL, BigQuery)\n- Proficiency in Python or R for data processing\n- Experience with BI tools (Tableau, Looker, or Metabase)\n- Ability to communicate findings clearly to non-technical stakeholders\n\nBenefits:\n- Salary: $1,400 – $2,200/month\n- GrabFood and GrabCar credits\n- Annual performance bonus\n- International career development program\n- Top-tier health insurance"
            }
        };

        for (String[] j : jobs) {
            Job job = new Job();
            job.setTitle(j[0]);
            job.setCompany(j[1]);
            job.setDescription(j[2]);
            jobRepository.save(job);
        }
    }
}
